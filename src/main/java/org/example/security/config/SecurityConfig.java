package org.example.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.security.service.CustomUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailService customUserDetailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/**").permitAll()
                .antMatchers("/**").access("hasRole('ROLE_MEMBER')");

        http.formLogin()
                .loginPage("/security/login")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/security/member")
                .failureUrl("/security/login-failed");

        http.logout()
                .logoutUrl("/security/logout")
                .invalidateHttpSession(true)
                .deleteCookies("remember-me", "JSESSIONID")
                .logoutSuccessUrl("/security/login")
                .permitAll();

        http.addFilterBefore(encodingFilter(), CsrfFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService)
                .passwordEncoder(bCryptPasswordEncoder);
    }




}
