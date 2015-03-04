package com.easygoapp.config;

import com.easygoapp.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Kir Kolesnikov on 04.03.2015.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF protection
        http.csrf()
                .disable()
                        // requests rules
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .anyRequest().permitAll()
                .and();

        http.formLogin()
                // login form page
                .loginPage("/login")
                        // URL login not success
                .failureUrl("/login?error")
                        // add permissions to login page to all
                .permitAll();

        http.logout()
                // add permissions to logout to all
                .permitAll()
                        // logout URL
                .logoutUrl("/logout")
                        // logout successful URL
                .logoutSuccessUrl("/login?logout")
                        // invalidation of current session
                .invalidateHttpSession(true);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //TODO encode password when user saves

}
