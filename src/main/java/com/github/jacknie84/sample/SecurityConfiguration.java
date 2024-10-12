package com.github.jacknie84.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var bearerTokenResolver = new DefaultBearerTokenResolver();
        var jwtDecoder = NimbusJwtDecoder.withPublicKey((RSAPublicKey) keyPair().getPublic()).build();
        bearerTokenResolver.setAllowUriQueryParameter(true);
        bearerTokenResolver.setAllowFormEncodedBodyParameter(true);

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .sessionManagement(it -> it.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .securityMatchers(it -> it.requestMatchers("/sample/**"))
                .oauth2ResourceServer(it -> it
                        .bearerTokenResolver(bearerTokenResolver)
                        .jwt(jwt -> jwt.decoder(jwtDecoder)))
                .authorizeHttpRequests(it -> it.anyRequest().authenticated())
                .build();
    }

    @Bean
    public KeyPair keyPair() {
        KeyPair keyPair;
        try {
            var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return keyPair;
    }
}
