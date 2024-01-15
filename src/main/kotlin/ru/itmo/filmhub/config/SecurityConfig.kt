package ru.itmo.filmhub.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class SecurityConfig : WebMvcConfigurer {

    @Override
    override fun addCorsMappings(cors: CorsRegistry) {
        cors.addMapping("/**")
    }
}