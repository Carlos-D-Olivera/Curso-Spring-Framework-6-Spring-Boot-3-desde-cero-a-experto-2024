package com.carlos.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingServicePointcuts {

    //En este aspecto solo declararemos los pointcuts para poderlos usar en los demas aspects

    @Pointcut("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){}

    @Pointcut("execution(* com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void greetingFooLoggerAspectPoinCut(){}
}
