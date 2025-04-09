package com.carlos.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/login", "/css/**", "/js/**", "/images/**").permitAll()
                                .anyRequest().authenticated()

                )
                .formLogin(frmlogin -> frmlogin
                        .defaultSuccessUrl("/home2", true)
                        .permitAll()
                )                  // Usar el formulario de login predeterminado de Spring Security
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // URL para el logout
                                .logoutSuccessUrl("/login") // URL a la que redirigir después del logout
                                .invalidateHttpSession(true))      // Permitir que todos accedan al logout
                .authenticationProvider(activeDirectoryLdapAuthenticationProvider()); // Proveedor de autenticación AD

        return http.build();
    }

    @Bean
    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        String domain = "Unicolombocj.com"; // Cambia por tu dominio AD
        String url = "ldap://192.168.1.10:389"; // Cambia por tu URL de servidor AD
        ActiveDirectoryLdapAuthenticationProvider provider =
                new ActiveDirectoryLdapAuthenticationProvider(domain, url);
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);
        return provider;
    }
}
