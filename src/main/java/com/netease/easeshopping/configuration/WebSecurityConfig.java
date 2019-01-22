package com.netease.easeshopping.configuration;

import com.netease.easeshopping.configuration.handler.AuthorizationFailHandler;
import com.netease.easeshopping.configuration.handler.AuthorizationLogoutSuccessHandler;
import com.netease.easeshopping.configuration.handler.AuthorizationSuccessHandler;
import com.netease.easeshopping.configuration.handler.MyAuthenticationEntryPoint;
import com.netease.easeshopping.service.impl.UserDetailsServiceImpl;
import com.netease.easeshopping.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/show").permitAll()
                //.antMatchers("/account", "/settleAccount", "/api/buy").hasAuthority("BUYER")
                //.antMatchers("/public", "/publicSubmit", "/api/upload", "/edit", "/api/delete").hasAuthority("SELLER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/login")
                .successHandler(new AuthorizationSuccessHandler())
                .failureHandler(new AuthorizationFailHandler())
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .logoutSuccessHandler(new AuthorizationLogoutSuccessHandler())
                .and()
                .exceptionHandling().authenticationEntryPoint(new MyAuthenticationEntryPoint())
                ;
        //http.csrf().disable();
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
                public boolean matches(CharSequence rawPassword, String encodedPassword){
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
