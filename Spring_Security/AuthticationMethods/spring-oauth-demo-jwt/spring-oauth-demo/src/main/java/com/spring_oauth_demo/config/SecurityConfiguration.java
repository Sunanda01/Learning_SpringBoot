package com.spring_oauth_demo.config;

import com.spring_oauth_demo.component.CustomOAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {
    private final CustomOAuth2SuccessHandler successHandler;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth->auth
                .requestMatchers("/","/login").permitAll()
                .anyRequest().authenticated())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf->csrf.disable())
                .oauth2Login(oauth->oauth.successHandler(successHandler));
        return http.build();
    }
}
// https://www.googleapis.com/oauth2/v3/userinfo => endpoint to test token