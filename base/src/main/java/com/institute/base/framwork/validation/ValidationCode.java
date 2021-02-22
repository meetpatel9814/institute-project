package com.institute.base.framwork.validation;

import com.institute.base.framwork.enums.BaseResultCode;
import com.institute.base.framwork.enums.ResultCode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Documented
public @interface ValidationCode {

    ValidationCodes value();
}
