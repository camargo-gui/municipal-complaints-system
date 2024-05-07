package org.example.municipalcomplaintssystem.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<JwtRequestFilter> registrationBean(){
        FilterRegistrationBean<JwtRequestFilter> register = new FilterRegistrationBean<>();
        register.setFilter(new JwtRequestFilter());
        register.addUrlPatterns("/api/*");
        return register;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/login", "/public/**", "/api/denuncia/").permitAll()
                            .requestMatchers("/api/orgao/**").hasRole("2")  // Restringe o acesso à rota /api/orgao/ apenas para usuários com role "USUARIO"// Restringe o acesso à rota /api/denuncia/ apenas para usuários com role "ADMIN"
                            .anyRequest().authenticated();  // Todas as outras requisições precisam de autenticação
                });
        return http.build();
    }
}