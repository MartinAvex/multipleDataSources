package com.xavier.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: DataSource
 * @Author: Xavier
 * @CreateTime: 2022-06-22  14:43
 * @Description: 自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String name() default "";

}
