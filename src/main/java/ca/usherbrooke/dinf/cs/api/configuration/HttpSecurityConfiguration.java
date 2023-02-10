package ca.usherbrooke.dinf.cs.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration(proxyBeanMethods = false)
class HttpSecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(
            final HttpSecurity http) throws Exception {
        // Does not apply for REST API as it does not query the CSRF
        // token prior mutation operation.
        http.csrf().disable();

        final UrlBasedCorsConfigurationSource configurationSource
                = new UrlBasedCorsConfigurationSource();

        configurationSource.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());

        http.cors().configurationSource(configurationSource);

        // Configure endpoint authorisations.
        http.authorizeHttpRequests()
                .anyRequest().permitAll();

        // Configure session management as stateless for REST API.
        http.sessionManagement()
                .sessionFixation().none()
                .sessionCreationPolicy(STATELESS);

        return http.build();
    }
}
