package com.carlos.curso.springboot.app.interceptor.springbootinterceptor;

import com.carlos.curso.springboot.app.interceptor.springbootinterceptor.interceptors.LoadingTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("timeInterceptor") //Se inyecta el interceptor que hemos creado
    private LoadingTimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(timeInterceptor); //Para todos los controladores

        //Podemos especificar cuales van a ser los controladores
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "/app/foo");

        //o podemos excluir
        //registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/bar", "/app/foo");

        //Tambien podemos espeficar todos los enpoints de una ruta
        //registry.addInterceptor(timeInterceptor).addPathPatterns("/app/**"); //Todos los metodos de la ruta app
    }
}
