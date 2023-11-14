package br.com.dermocosmeticos.appDermocosmeticos.Configuration;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResultUtil<T> {
    private final String MSG_USUARIO = "Operação realizada com sucesso";

    public ResultUtil() {
    }

    public ResponseEntity<Result<T>> resultSucesso(HttpStatus httpStatus) {
        return this.resultSucesso(httpStatus, "Operação realizada com sucesso", (T) null);
    }

    public ResponseEntity<Result<T>> resultSucesso(HttpStatus httpStatus, T dados) {
        return this.resultSucesso(httpStatus, "Operação realizada com sucesso", dados);
    }

    public ResponseEntity<Result<T>> resultSucesso(HttpStatus httpStatus, String msgUsuario, T dados) {
        return ResponseEntity.status(httpStatus).body(this.entidadeResult(httpStatus.value(), (String)null, msgUsuario, dados));
    }

    public ResponseEntity<Result<T>> resultErro(HttpStatus httpStatus, String msgTecnica, String msgUsuario) {
        return ResponseEntity.status(httpStatus).body(this.entidadeResult(httpStatus.value(), msgTecnica, msgUsuario, (T) null));
    }

    private Result<T> entidadeResult(int cdRetorno, String msgTecnica, String msgUsuario, T dados) {
        Result<T> result = new Result();
        result.setCdRetorno(cdRetorno);
        if (msgUsuario != null) {
            result.setMsgUsuario(msgUsuario);
        }

        if (msgTecnica != null) {
            result.setMsgTecnica(msgTecnica);
        }

        if (dados != null) {
            result.setDados(dados);
        }

        return result;
    }
}