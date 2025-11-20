package br.dev.vktgabriel.rotaliteria.upx6.validation;

import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.DataFutura;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataFuturaValidation implements ConstraintValidator<DataFutura, String> {
    @Override
    public void initialize(DataFutura constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        try {
            LocalDate localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return localDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
