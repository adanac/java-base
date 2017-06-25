package com.feagle.learn.annotation.t1;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Created by Feagle on 2017/6/2.
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Description {
    String desc();
    String author() default "adanac";
    int age() default 16;
}
