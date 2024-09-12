package com.catalogo.proveedores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    // configuration One
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                // .csrf()  por defecto viene activo
//                .authorizeHttpRequests()
//                .requestMatchers(new AntPathRequestMatcher("/proveedores/nonsecured")).permitAll() // peticiones que coincidan con los endpoints (permiso sin iniciar sesion)
//                .anyRequest().authenticated() // cualquier otro necesita estar autenticado
//                .and()
//                .formLogin().permitAll() // todos pueden acceder al formulario para poder identificarse
//                .and()
//                .httpBasic()
//                .and()
//                .build();
//    }

    // configuration two
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(new AntPathRequestMatcher("/proveedores/nonsecured")).permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin()
                    .successHandler(successHandler()) // opcional URL a donde se dirige despues de iniciar sesion
                    .permitAll()
                .and()
                // configuracion de la sesion
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // - Always, if_required, never, stateless
                    .invalidSessionUrl("/proveedores/nonsecured")
                    .maximumSessions(1)
                    .expiredUrl("/proveedores/nonsecured")
                    .sessionRegistry(sessionRegistry())
                .and()
                .sessionFixation()
                    .migrateSession() // migrateSession cuando se detecta un ataque de fijacion de sesion, spring genera otro
                .and()
                .build();

    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public AuthenticationSuccessHandler successHandler(){
        return ( (request, response, auth) -> {
            response.sendRedirect("/proveedores/session");
        });
    }
}
