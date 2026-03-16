package com.quanxiaoha.framework.biz.operationlog.aspect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationlog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";

}
