package com.example.project_backend.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // SecurityFilterChain 을 사용하여 보안 설정
    // Spring Security 6이상 에서는 cors(), csrf()가 deprecated 되었기 때문에 HttpSecurityCustomizer 방식을 사용
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new CorsConfiguration();
                    corsConfig.addAllowedOrigin("*"); // 모든 도메인 허용
                    corsConfig.addAllowedMethod("*"); // 모든 HTTP 메서드 허용
                    corsConfig.addAllowedHeader("*"); // 모든 헤더 허용
                    return corsConfig;
                }))
                // CSRF 보호 기능 비활성화 (JWT 기반 인증 사용 시 필요 없음)
                // -> CSRF는 주로 세션 기반 인증에서 필요하며, JWT는 세션을 사용하지 않으므로 disable() 설정
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // "/api/auth/**" 로 시작하는 URL 패턴은 인증 없이 접근 가능하도록 허용
                        // -> 회원가입, 로그인 등의 API는 누구나 사용할 수 있어야 하기 때문
                        .requestMatchers("/api/auth/**").permitAll()

                        // 그 외의 모든 요청은 반드시 인증된 사용자만 접근 가능
                        // -> JWT 검증을 통과한 사용자만 API를 사용할 수 있음
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
