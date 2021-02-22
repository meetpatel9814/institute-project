package com.institute.base.framwork.validation;

import lombok.val;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class IsDateValidatorImpl implements ConstraintValidator<IsDate, String> {
    private String pattern;
    @Override
    public void initialize(IsDate constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        DateFormat sdf = new SimpleDateFormat(this.pattern);
        sdf.setLenient(false);
        try {
            sdf.parse(value);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
