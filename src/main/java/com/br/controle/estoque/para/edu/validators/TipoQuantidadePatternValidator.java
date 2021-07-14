package com.br.controle.estoque.para.edu.validators;

import com.br.controle.estoque.para.edu.annotations.TipoQuantidadePattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TipoQuantidadePatternValidator implements ConstraintValidator<TipoQuantidadePattern, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(TipoQuantidadePattern annotation) {
        try {
            pattern = Pattern.compile(annotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}

