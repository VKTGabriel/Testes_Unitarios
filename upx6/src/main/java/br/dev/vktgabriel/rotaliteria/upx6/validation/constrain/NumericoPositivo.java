package br.dev.vktgabriel.rotaliteria.upx6.validation.constrain;

import br.dev.vktgabriel.rotaliteria.upx6.validation.NumericoPositivoValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumericoPositivoValidation.class)
public @interface NumericoPositivo {

    String message() default "Número Inválido: Insira um numeral positivo";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
