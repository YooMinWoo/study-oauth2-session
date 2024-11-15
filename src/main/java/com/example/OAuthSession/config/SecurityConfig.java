package com.example.OAuthSession.config;

import com.example.OAuthSession.oauth2.CustomClientRegistrationRepo;
import com.example.OAuthSession.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomClientRegistrationRepo customClientRegistrationRepo;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

       http
               .authorizeHttpRequests(auth -> auth
                       .requestMatchers("/","/oauth2/**","/login/**").permitAll()
                       .anyRequest().authenticated()
               )
               .csrf(AbstractHttpConfigurer::disable)
               .formLogin(AbstractHttpConfigurer::disable)
               .httpBasic(AbstractHttpConfigurer::disable)
               .oauth2Login(oauth2 -> oauth2
                       .loginPage("/login")
                       .clientRegistrationRepository(customClientRegistrationRepo.clientRegistrationRepository())
                       .userInfoEndpoint((userInfoEndpointConfig -> userInfoEndpointConfig
                               .userService(customOAuth2UserService)))
               )



       ;

               return http.build();
    }
}
