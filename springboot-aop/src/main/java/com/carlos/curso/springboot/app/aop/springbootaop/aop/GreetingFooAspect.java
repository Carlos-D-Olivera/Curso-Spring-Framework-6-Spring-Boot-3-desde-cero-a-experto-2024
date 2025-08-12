package com.carlos.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1) //Primero se ejecuta este aspecto //Entra primero y sale de ultimo
@Component
@Aspect
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    private void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes primero: "+method+"() invocado con los parametros "+args);
    }

    @After("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues Primero: "+method+" con los parametros "+args);
    }


}
