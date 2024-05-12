/*package com.example.Proyecto.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;


    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private final CustomUsersDetailsService authProvider;

    @Autowired
    public SecurityConfig(CustomUsersDetailsService authProvider) {
        this.authProvider = authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authRequest ->
                authRequest
                    .requestMatchers(HttpMethod.GET).permitAll()
                    .requestMatchers(HttpMethod.POST).permitAll()
                    .requestMatchers(HttpMethod.DELETE).permitAll()
                    .requestMatchers(HttpMethod.PUT).permitAll()
                    .requestMatchers(HttpMethod.OPTIONS).permitAll()
                    .requestMatchers("/generate-token","/usuarios/**","/producto/**").permitAll()
                    .anyRequest().authenticated()
            )
            .sessionManagement(sessionManager ->
                sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authProvider)
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .and()
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
}*/