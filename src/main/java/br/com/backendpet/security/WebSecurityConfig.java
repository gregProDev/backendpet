package br.com.backendpet.security;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

   // private final CustomBasicAuthenticationFilter customBasicAuthenticationFilter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @CrossOrigin
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return  http.csrf(csrf -> csrf.disable())
                //.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((request) -> request
                        .requestMatchers(HttpMethod.POST, "/usuario/**", "/allusuario/**", "/login/**").permitAll()
                        .anyRequest()
                        .authenticated()

                )//.addFilterBefore((Filter) customBasicAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

  /*  @Bean
    protected void configure(HttpSecurity http) throws Exception {
          http.csrf().disable()
                  .authorizeRequests()
                  .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
                  .anyRequest()
                  .authenticated()
                  .and();
    }*/
}
