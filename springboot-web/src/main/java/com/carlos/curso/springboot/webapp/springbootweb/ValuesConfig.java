package com.carlos.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//Dentro del propertySources agregamos las  configuraciones

/*
*   El encoding charset es un atributo del @PropertySource para poderle especificar con que
*   codificacion se abre el archivo y de esta manera poderlo visualizar correctamente con
*   os acentos y caracteres especiales.
*/

@PropertySources({
        @PropertySource(value="classpath:values.properties", encoding = "")//, //agregamos el archivo de configuracion que hemos creado para que Spring lo reconozca
        //@PropertySource("classpath:values.properties")
})
public class ValuesConfig {
}
