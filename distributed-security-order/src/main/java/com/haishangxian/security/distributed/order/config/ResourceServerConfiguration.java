package com.haishangxian.security.distributed.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "order";
    @Autowired
    TokenStore tokenStore;
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('ROLE_API')")
                .and()
                .csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .antMatchers("/").hasAuthority("SystemContent")
//                .antMatchers("/view/**").hasAuthority("SystemContentView");
//                .antMatchers("/insert/**").hasAuthority("SystemContentInsert")
//                .antMatchers("/update/**").hasAuthority("SystemContentUpdate")
//                .antMatchers("/delete/**").hasAuthority("SystemContentDelete");
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId((RESOURCE_ID))
                .tokenStore(tokenStore)
                .stateless(true);
    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/**").access("#oauth2.hasScope('all')")
//                .and()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }

    //用jwt   不再远程校验
//    @Bean
//    public ResourceServerTokenServices tokenServices(){
//        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:7777/oauth/check_token");
//        remoteTokenServices.setClientId("c1");
//        remoteTokenServices.setClientSecret("secret");
//        return remoteTokenServices;
//    }

}
