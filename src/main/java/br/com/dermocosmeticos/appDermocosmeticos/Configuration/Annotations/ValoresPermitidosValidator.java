package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Annotations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class ValoresPermitidosValidator implements ConstraintValidator<ValoresPermitidos, Object> {
    private List<String> permitidos;
    private String mensagem;

    ValoresPermitidosValidator() {
    }

    public void initialize(ValoresPermitidos valoresPermitidos) {
        this.permitidos = Arrays.asList(valoresPermitidos.value());
        this.mensagem = valoresPermitidos.message() + this.permitidos;
    }

    public boolean isValid(Object valor, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if (valor == null) {
            isValid = true;
        } else if (valor instanceof ArrayList) {
            for(Iterator var4 = ((ArrayList)valor).iterator(); var4.hasNext(); isValid = true) {
                Object valorItem = var4.next();
                if (!this.permitidos.contains(valorItem.toString())) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(this.mensagem).addConstraintViolation();
                    return false;
                }
            }
        } else if (this.permitidos.contains(valor.toString())) {
            isValid = true;
        } else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(this.mensagem).addConstraintViolation();
        }

        return isValid;
    }
}