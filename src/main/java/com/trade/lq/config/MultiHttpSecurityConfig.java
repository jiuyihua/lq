package com.trade.lq.config;

import com.trade.lq.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


@Configuration
public class MultiHttpSecurityConfig{


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//new BCryptPasswordEncoder();
    }


    @Autowired
    UserServiceImpl userService;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }



/*
        @Bean
        CustomFilterInvocationSecurityMetadataSource cf() {
            return new CustomFilterInvocationSecurityMetadataSource();
        }
        @Bean
        CustomAccessDecisionManager ca() {
            return new CustomAccessDecisionManager();
        }*/

       /* @Bean
        FilterSecurityInterceptor cfismsAndcadm(FilterSecurityInterceptor object){
            object.setSecurityMetadataSource(cf());
            object.setAccessDecisionManager(ca());
            return object;
        }
*/



    @Configuration
    @Order(1)
    public static class AdminSeurityConfig extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/admin/**").hasRole("admin")
                    .antMatchers("/dba/**").hasRole("dba")
                    .antMatchers("/user/**").hasRole("user")
                    .antMatchers("/app/**").hasRole("user")
                    .antMatchers("/hello/**","/queue/**")
                    .access("hasAnyRole('user','admin','dba')")//hasRole("user,admin,dba")
                    .antMatchers("/register").permitAll()
                    .antMatchers("/confirm").permitAll()
                    .antMatchers("/login/**").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/vendor/**").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login_page").permitAll()
                    .loginProcessingUrl("/login").permitAll()
                    .withObjectPostProcessor(
                            new ObjectPostProcessor<FilterSecurityInterceptor>() {
                                @Override
                                public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                                    object.setSecurityMetadataSource(new CustomFilterInvocationSecurityMetadataSource());
                                    object.setAccessDecisionManager(new CustomAccessDecisionManager());
                                    return object;
                                }
                            })
                    .and().csrf().disable();
        }


    }



    /*OAuth2 token验证*/
    @Configuration
    @Order(2)
    public static class AppSeurityConfig extends WebSecurityConfigurerAdapter{


        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
        @Bean
        @Override
        protected UserDetailsService userDetailsService() {
            return super.userDetailsService();
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/dba/**").hasRole("DBA")
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/app/**").hasRole("USER")
                    .antMatchers("/hello/**","/queue/**")
                    .access("hasAnyRole('user','admin','dba')")//hasRole("user,admin,dba")
                    .antMatchers("/register").permitAll()
                    .antMatchers("/confirm").permitAll()
                    .antMatchers("/login/**").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/vendor/**").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .and().antMatcher("/oauth/**").authorizeRequests().antMatchers("/oauth/**").permitAll()
                    .withObjectPostProcessor(
                            new ObjectPostProcessor<FilterSecurityInterceptor>() {
                                @Override
                                public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                                    object.setSecurityMetadataSource(new CustomFilterInvocationSecurityMetadataSource());
                                    object.setAccessDecisionManager(new CustomAccessDecisionManager());
                                    return object;
                                }
                            })

                    .and()
                    .csrf().disable();
        }
    }


    @Configuration
    public static class OtherSeurityConfig extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
/*
                    http.authorizeRequests()
                        .anyRequest()
                        .authenticated()
                        .and().formLogin()
                        .loginProcessingUrl("/login")
                        .permitAll()
                        .and()
                        .csrf()
                        .disable();*/
        }
    }

}
