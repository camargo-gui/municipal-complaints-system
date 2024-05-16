package org.example.municipalcomplaintssystem.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Padrão para todas as rotas
                .allowedOrigins("http://localhost:8081") // Permitir somente de https://seusite.com
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("*") // Cabeçalhos permitidos
                .allowCredentials(true); // Suporte para cookies entre domínios
    }
}
