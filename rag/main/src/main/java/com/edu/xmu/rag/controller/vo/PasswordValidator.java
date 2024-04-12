package com.edu.xmu.rag.controller.vo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private Password password;

    @Override
    public void initialize(Password constraintAnnotation) {
        password = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String pattern = password.pattern();
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(value);
        return matcher.matches();
    }
}
