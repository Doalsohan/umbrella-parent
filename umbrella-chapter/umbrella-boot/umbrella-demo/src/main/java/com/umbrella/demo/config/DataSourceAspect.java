package com.umbrella.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;


@Slf4j
@Aspect
@Order(-1)
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(CurrentDS)")
    public void dsPointCut() {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();

        Method method = signature.getMethod();

        CurrentDS dataSource = method.getAnnotation(CurrentDS.class);

        if (Objects.nonNull(dataSource)) {
            log.info("[切换数据源为:{}]",dataSource.value().getName());
            DynamicDataSourceContextHolder.setDataSourceKey(dataSource.value());
        }

        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            System.out.println("销毁数据源" + dataSource.value().getName());
            DynamicDataSourceContextHolder.clearDataSourceKey();
        }
    }
}
