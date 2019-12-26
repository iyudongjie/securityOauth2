package com.haishangxian.security.distributed.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: yudongjie
 * @CreateDate: 2019-12-26 11:07
 */
@Configuration
//基于方法的授权
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/").hasAuthority("bbb");
//                .antMatchers("/view/**").hasAuthority("SystemContentView");
//                .antMatchers("/insert/**").hasAuthority("SystemContentInsert")
//                .antMatchers("/update/**").hasAuthority("SystemContentUpdate")
//                .antMatchers("/delete/**").hasAuthority("SystemContentDelete");
        http
                .csrf()
                .disable()
                .authorizeRequests()

                .antMatchers("/order/**")
                .authenticated()
                .anyRequest()
                .permitAll();
    }


}
