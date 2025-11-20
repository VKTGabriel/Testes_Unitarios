package br.dev.vktgabriel.rotaliteria.upx6.validation.constrain;

import br.dev.vktgabriel.rotaliteria.upx6.validation.CepValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CepValidation.class)
public @interface CEP {

    String message() default "Cep invalido: informe o cep com 8 digitos numéricos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
