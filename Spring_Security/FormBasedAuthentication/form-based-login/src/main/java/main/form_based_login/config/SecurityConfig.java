package main.form_based_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();
        UserDetails user2= User.builder()
                .username("user")
                .password("{noop}user")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth->auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/user").hasRole("USER")
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()

        )
                .sessionManagement(session->
                        session.maximumSessions(1)
                                .maxSessionsPreventsLogin(true))
         .csrf(csrf -> csrf.disable())   // needed for H2
         .headers(headers -> headers
         .frameOptions(frame -> frame.disable()))
                .formLogin(form -> form
                        .failureHandler((request, response, exception) -> {

                            if (exception instanceof org.springframework.security.web.authentication.session.SessionAuthenticationException) {
                                response.sendRedirect("/login?maxSession=true");
                            } else {
                                response.sendRedirect("/login?error=true");
                            }

                        })
                );
        return http.build();
    }
}
