package com.movies.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {

        final String ALL_PATH = "/**";
        final String ALL_OPERATOR = "*";
        final List<String> ALL_SINGLETON_LIST = Collections.singletonList(ALL_OPERATOR);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(ALL_SINGLETON_LIST);
        config.setAllowedMethods(ALL_SINGLETON_LIST);
        config.setAllowedHeaders(ALL_SINGLETON_LIST);
        source.registerCorsConfiguration(ALL_PATH, config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}
