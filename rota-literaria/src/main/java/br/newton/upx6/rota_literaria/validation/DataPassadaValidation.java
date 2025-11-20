package br.newton.upx6.rota_literaria.validation;

import br.newton.upx6.rota_literaria.validation.constrain.DataPassada;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataPassadaValidation implements ConstraintValidator<DataPassada, String> {
    @Override
    public void initialize(DataPassada constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        try {
            LocalDate localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return localDate.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
