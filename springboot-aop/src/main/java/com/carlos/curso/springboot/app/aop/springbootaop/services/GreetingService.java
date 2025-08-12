package com.carlos.curso.springboot.app.aop.springbootaop.services;

public interface GreetingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);
}
