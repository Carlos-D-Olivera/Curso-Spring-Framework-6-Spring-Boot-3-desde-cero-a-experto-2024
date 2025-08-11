package com.carlos.curso.springboot.calendar.interceptor.springboothorario.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CalendarInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CalendarInterceptor.class);
    @Value("${config.calendar.open}")
    private Integer open;

    @Value("${config.calendar.close}") //Obtenemos la configuracion que establecimos en properties
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); //Obtenemos la hora en formato 24hrs

        if(hour >= open && hour < close){
            StringBuilder message = new StringBuilder("Bienvenidos al horario de atencion a clientes");
            message.append(", atendemos desde las ");
            message.append(open);
            message.append("hrs.");
            message.append(" hasta las");
            message.append(close);
            message.append("hrs.");
            message.append(" Gracias por su visita!");
            request.setAttribute("message",message.toString());
            return true;
        }


        //Como no esta dentro del rango de horas se devuelve una respuesta de error

        StringBuilder message = new StringBuilder("Cerrado, fuera del horario de atencion ");
        message.append("por favor visitenos desde las ");
        message.append(open);
        message.append("hrs.");
        message.append(" hasta las");
        message.append(close);
        message.append(". Gracias por su visita!");

        ObjectMapper mapper = new ObjectMapper(); //Lo usaremos para convertir al formato JSON preestablecido para la respuesta

        Map<String, Object> error = new HashMap<>();
        error.put("mensaje", message.toString());
        error.put("date", new Date().toString());
        error.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());


        response.setContentType("application/json"); //es formato JSON
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        response.getWriter().write(mapper.writeValueAsString(error));


        return false; //No se ejecutara el controlador
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
