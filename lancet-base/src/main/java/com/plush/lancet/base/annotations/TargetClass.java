package com.plush.lancet.base.annotations;


import com.plush.lancet.base.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/23
 * Email: lijt@eetrust.com
 */
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD})
public @interface TargetClass {
    String value();

    Scope scope() default Scope.SELF;
}
