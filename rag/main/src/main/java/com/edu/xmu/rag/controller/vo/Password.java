package com.edu.xmu.rag.controller.vo;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface Password {

    String pattern() default "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\\\W_])^.{6}$";

    String message() default "密码合法性检查";

    Class<?>[] groups() default { };

    Class<?extends Payload>[] payload()default {};

    interface Default{

    }

}
