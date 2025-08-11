package com.carlos.curso.springboot.calendar.interceptor.springboothorario.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Configuracion para el interceptor
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    CalendarInterceptor calendarInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //registry.addInterceptor(calendarInterceptor); //para todos
        registry.addInterceptor(calendarInterceptor).addPathPatterns("/foo"); //solo para foo
    }
}
