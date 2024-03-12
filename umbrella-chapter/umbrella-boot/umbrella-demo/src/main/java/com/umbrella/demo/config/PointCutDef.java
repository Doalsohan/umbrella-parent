package com.umbrella.demo.config;

import org.aspectj.lang.annotation.Pointcut;
public interface PointCutDef {

    @Pointcut("execution(public * com.umbrella.demo.controller.*.*(..))")
    default void controllerMethod() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    default void postMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    default void getMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    default void putMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    default void deleteMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    default void requestMapping() {
    }

    @Pointcut("controllerMethod() && (requestMapping() || postMapping() || getMapping() || putMapping() || deleteMapping())")
    default void apiMethod() {
    }
}
