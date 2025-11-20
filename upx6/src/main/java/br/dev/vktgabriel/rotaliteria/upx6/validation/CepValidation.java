package br.dev.vktgabriel.rotaliteria.upx6.validation;

import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.CEP;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CepValidation implements ConstraintValidator<CEP, String> {
    @Override
    public void initialize(CEP constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {return true;}
        String cep = s.replaceAll("[^0-9]", "").trim();
        return cep.length() == 8;
    }
}
