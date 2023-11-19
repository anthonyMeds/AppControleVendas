package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtil;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.DateTimeException;
import java.util.Objects;

@RestControllerAdvice
public class ApiExceptionHandler {
    private final ResultUtil resultUtil;

    @Autowired
    public ApiExceptionHandler(ResultUtil resultUtil) {
        this.resultUtil = resultUtil;
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    protected ResponseEntity<EntidadeResult> handleHttpMessageNotReadable(HttpMessageNotReadableException hmnre, JsonMappingException jme) throws Throwable {
        StringBuilder msgTecnica = (new StringBuilder(((JsonMappingException.Reference)jme.getPath().get(0)).getFieldName())).append(": ");

        try {
            throw hmnre.getRootCause();
        } catch (DateTimeException var5) {
            msgTecnica.append("data ou hora inválida");
        } catch (Exception var6) {
            msgTecnica.append("valor inválido");
        }

        return this.resultUtil.resultErro(HttpStatus.BAD_REQUEST, msgTecnica.toString(), "Requisição possui campo inválido. Faça o preenchimento correto e tente novamente");
    }

    @ExceptionHandler({HttpMessageNotWritableException.class})
    protected ResponseEntity<EntidadeResult> handleHttpMessageNotWritable(HttpMessageNotWritableException hmnwe) {
        return this.resultUtil.resultErro(HttpStatus.INTERNAL_SERVER_ERROR, hmnwe.toString(), "Não foi possível realizar a operação");
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    protected ResponseEntity<EntidadeResult> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException hrmnse) {
        StringBuilder msgUsuario = (new StringBuilder("O método ")).append(hrmnse.getMethod()).append(" não é suportado para esta solicitação. Método suportado: ").append(hrmnse.getSupportedMethods()[0]);
        return this.resultUtil.resultErro(HttpStatus.METHOD_NOT_ALLOWED, hrmnse.toString(), msgUsuario.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<EntidadeResult> handleMethodArgumentNotValid(MethodArgumentNotValidException manve) {
        String msgTecnica = manve.getBindingResult().getFieldError().getField() + ": " + manve.getBindingResult().getFieldError().getDefaultMessage();
        return this.resultUtil.resultErro(HttpStatus.BAD_REQUEST, msgTecnica, "Requisição possui campo inválido. Faça o preenchimento correto e tente novamente");
    }

    @ExceptionHandler(JpaSystemException.class)
    protected ResponseEntity<EntidadeResult> handleJpaSystemException(JpaSystemException jpaException) {
        Throwable rootCause = jpaException.getRootCause();

        return this.resultUtil.resultErro(HttpStatus.INTERNAL_SERVER_ERROR, "Ano inválido.", "Não foi possível realizar a operação");
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Result> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) throws Throwable {
        StringBuilder msgTecnica = (new StringBuilder(methodArgumentTypeMismatchException.getName())).append(": ");

        try {
            throw (Throwable) Objects.requireNonNull(methodArgumentTypeMismatchException.getRootCause());
        } catch (DateTimeException var4) {
            msgTecnica.append("data inválida");
        } catch (Exception var5) {
            msgTecnica.append("deve ser do tipo ").append(((Class)Objects.requireNonNull(methodArgumentTypeMismatchException.getRequiredType())).getName());
        }

        return this.resultUtil.resultErro(HttpStatus.BAD_REQUEST, msgTecnica.toString(), "Requisição possui campo inválido. Faça o preenchimento correto e tente novamente");
    }

    @ExceptionHandler({ServiceException.class})
    protected ResponseEntity<EntidadeResult> handleService(ServiceException se) {
        return this.resultUtil.resultErro(HttpStatus.BAD_REQUEST, se.toString(), se.getMessage());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<EntidadeResult> handleGenericException(Exception e) {
        return this.resultUtil.resultErro(HttpStatus.INTERNAL_SERVER_ERROR, e.toString(), "Não foi possível realizar a operação");
    }






}
