package br.dev.vktgabriel.rotaliteria.upx6.validation.constrain;

import br.dev.vktgabriel.rotaliteria.upx6.validation.DataFuturaValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataFuturaValidation.class)
public @interface DataFutura {

    String message() default "Data inválida: Insira uma data no padrão [dd/mm/aaaa] posterior ao dia de hoje";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
