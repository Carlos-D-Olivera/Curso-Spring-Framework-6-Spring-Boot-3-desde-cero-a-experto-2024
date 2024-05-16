package com.carlos.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//Dentro del propertySources agregamos las  configuraciones
@PropertySources({
        @PropertySource(value="classpath:values.properties")//, //agregamos el archivo de configuracion que hemos creado para que Spring lo reconozca
        //@PropertySource("classpath:values.properties")
})
public class ValuesConfig {
}
