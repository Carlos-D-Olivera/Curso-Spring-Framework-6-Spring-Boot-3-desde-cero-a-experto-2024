package com.carlos.curso.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Component
@Aspect
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //106.
    //Dentro del @Before se debe colocar el poinCut osea el/los metodos a interceptar
    //Tambien hay que colocar el valor que devuelve el metodo/poincut, tambien puede ser *
    //@Before("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingServiceImpl.sayHello(..))")
    @Before("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    //@Before("execution(* com.carlos.curso.springboot.app.aop.springbootaop..*.*(..))")
    //@Before("execution(* *.*(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: "+method+" con los argumentos "+args);
    }


    @After("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: "+method+" con los argumentos "+args);
    }


    //Despues de retornar si no ocurre algun error
    @AfterReturning("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: "+method+" con los argumentos "+args);
    }

    //Despues de que ocurra algun error
    @AfterThrowing("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de lanzar la excepcion: "+method+" con los argumentos "+args);
    }


    //Se usa ProceedingJoinPoint en vez de JoinPoint ya que around intercepta el metodo en procedimiento, envuelve la ejecucion
    @Around("execution(String com.carlos.curso.springboot.app.aop.springbootaop.services.*.*(..))")
    public Object LoggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("El metodo "+method+"() con los parametros "+args);
            result = joinPoint.proceed();
            logger.info("El metodo "+method+"() retorna el resultado"+result);
            return  result;
        }catch (Throwable e){
            logger.info("Error en la llamada del metodo " + method + "()");
            throw e;
        }
    }
}
