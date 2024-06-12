package com.cdog.springboot.di.app.SpringBoot_di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration()
@PropertySources({
        @PropertySource("classpath:valores.properties")
})
public class ConfigProperties {
}
