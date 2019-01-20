package com.netease.easeshopping.configuration;

import com.netease.easeshopping.service.impl.UserDetailsServiceImpl;
import com.netease.easeshopping.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/show", "/login").permitAll()
                //.antMatchers("/account", "/settleAccount", "/api/buy").hasAuthority("BUYER")
                //.antMatchers("/public", "/publicSubmit", "/api/upload", "/edit", "/api/delete").hasAuthority("SELLER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/api/login")
                .successHandler(new AuthorizationSuccessHandler())
                .failureHandler(new AuthorizationFailHandler())
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new AuthorizationLogoutSuccessHandler())
                .permitAll();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        try {
            auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new PasswordEncoder(){
                @Override
                public String encode(CharSequence rawPassword) {
                    return rawPassword.toString();
                }

                @Override
                public boolean matches(CharSequence rawPassword, String encodedPassword) {
                    boolean flag = false;
                    try {
                        flag = encodedPassword.equals(Md5Util.encodeByMd5((String)rawPassword).toLowerCase());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return flag;
                }});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
