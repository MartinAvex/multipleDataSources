package com.xavier.aspect;

import com.xavier.annotation.DataSource;
import com.xavier.datasource.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: DataSourceAspect
 * @Author: Xavier
 * @CreateTime: 2022-06-22  14:43
 * @Description: AOP切面
 */

@Aspect
@Component
@Slf4j
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    /**
     *  设置切入点
     *  只有使用@DataSource注解才会触发around
     **/
    @Pointcut("@annotation(com.xavier.annotation.DataSource)")
    public void dataSourcePointCut() {}

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取方法签名
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        logger.info("execute DataSourceAspect around ========> " + method.getName());
        //获取自定义注解
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource == null) {
            DynamicDataSource.setDataSource("master-db");
            logger.info("使用默认数据源");
        } else if ("slave".equals(dataSource.name())) {
            DynamicDataSource.setDataSource("slave-db");
            logger.info("使用指定数据源=========>"+dataSource.name());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.info("后置处理，恢复默认数据源");
        }
    }














}
