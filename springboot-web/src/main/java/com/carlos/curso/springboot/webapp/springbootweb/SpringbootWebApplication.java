package com.carlos.curso.springboot.webapp.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
////Dentro del propertySources agregamos las  configuraciones
//@PropertySources({
//	@PropertySource("classpath:values.properties")//, //agregamos el archivo de configuracion que hemos creado para que Spring lo reconozca
//	//@PropertySource("classpath:values.properties")
//})
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
