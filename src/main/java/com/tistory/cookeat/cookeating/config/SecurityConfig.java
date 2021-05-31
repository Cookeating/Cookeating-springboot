package com.tistory.cookeat.cookeating.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //TODO : 2021-05-31 // 초기 세팅 Security 비활성화 설정 기본적인 기능 추가 후에 적용 예정.

        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }
}

