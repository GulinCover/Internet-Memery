package com.gulincover.accessApi.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//@Aspect
//@Component
public class UserIdAspect {
    @Around("execution(* com.gulincover.accessApi.controller.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        DefaultParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        String[] parameterNames = pnd.getParameterNames(method);


        Object proceed = pjp.proceed();
        return proceed;
    }
}










