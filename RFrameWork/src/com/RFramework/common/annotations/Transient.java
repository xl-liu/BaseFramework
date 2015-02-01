package com.RFramework.common.annotations;

/**
 * Created by wangronghua on 15/1/27.
 */

import java.lang.annotation.*;

/**
 * @author Olafur Gauti Gudmundsson
 * @author Scott Hernandez
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Transient {

}
