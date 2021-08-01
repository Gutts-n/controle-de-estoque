package com.br.controle.estoque.annotations;

import com.br.controle.estoque.validators.TipoQuantidadePatternValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = TipoQuantidadePatternValidator.class)
public @interface TipoQuantidadePattern {

    String regexp();
    String message() default "{validacao.tipoQuantidade.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
