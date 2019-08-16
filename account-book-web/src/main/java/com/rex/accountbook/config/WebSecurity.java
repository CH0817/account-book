package com.rex.accountbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // disable CSRF
        http.csrf().disable();
        // need has ROLE_USER
        http.authorizeRequests()
                .antMatchers("/accounts/**", "/account/types", "/items", "/trades/**")
                .hasRole("USER")
                .and();
        // customer login page
        http.formLogin().loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("pwd")
                .defaultSuccessUrl("/main")
                .failureForwardUrl("/login?error=true")
                .permitAll()
                .and();
        // all requests need authorize
        http.authorizeRequests().anyRequest().authenticated().and();
    }

    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) {
        // 忽略 jquery-easyui-1.8.1 資料夾底下所有檔案驗證
        web.ignoring().antMatchers("/webjars/**");
    }

}
