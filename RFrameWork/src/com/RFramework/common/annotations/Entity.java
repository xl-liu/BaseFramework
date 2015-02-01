package com.RFramework.common.annotations;

import java.lang.annotation.*;

/**
 * Created by wangronghua on 15/1/27.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface Entity {
    String value() default "";
}
