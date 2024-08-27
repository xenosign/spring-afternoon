package org.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserConfig implements WebMvcConfigurer {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("시큐리티 인터셉터가 등록 되었습니다!");
//        registry.addInterceptor(new AuthenticationInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/user/**", "/resources/**");
//    }
}










