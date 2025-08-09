package com.carlos.curso.springboot.app.interceptor.springbootinterceptor.interceptors;

//import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Random;

/**
 * Cuando creamos un interceptor debemos implementar la clase HandlerInterceptor
 */

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod method = ((HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor: preHandle() entrando .... " + method.getMethod().getName());


        Long start = System.currentTimeMillis(); //Obtenemos el tiempo actual en milisegundos
        request.setAttribute("start", start); //Lo almacenamos como un atributo en el objeto request

        //Simulamos un delay
        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);


//        Map<String, String> json = new HashMap<>();
//        json.put("error","No tienes acceso a esta pagina.");
//        json.put("date",new Date().toString());
//
//        //Para devolver la respuesta debemos usar este objeto ya que no estamos en un RestController
//        // ObjectMapper es usado por los RestController de manera automatica en este caso hay que importarlo
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(json);
//
//        response.setContentType("application/json"); //Usamos el tipo JSON ya que en ese formato devolveremos el objeto.
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.getWriter().write(jsonString); //Le pasamos el json que construimos
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("LoadingTimeInterceptor: postHandle() saliendo .... " + ((HandlerMethod) handler).getMethod().getName());

        Long end = System.currentTimeMillis();
        Long start = (Long) request.getAttribute("start"); //Recuperamos el valor que guardamos en el preHandle

        Long result = end - start;
        logger.info("Tiempo transcurrido: "+result+" milisegundos.");
    }
}
