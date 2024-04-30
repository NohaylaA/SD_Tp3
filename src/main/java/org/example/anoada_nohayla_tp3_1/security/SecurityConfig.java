package org.example.anoada_nohayla_tp3_1.security;

import lombok.AllArgsConstructor;
import org.example.anoada_nohayla_tp3_1.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig
{
    private PasswordEncoder passwordEncoder;
    private UserDetailServiceImpl userDetailServiceImpl;
    //@Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource)
    {
        return new JdbcUserDetailsManager(dataSource);
    }



    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        return new InMemoryUserDetailsManager(
                User.withUsername("nohayla").password(passwordEncoder.encode("1234"))
                        .roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder.encode("1234"))
                        .roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234"))
                        .roles("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
        httpSecurity.authorizeRequests().requestMatchers("/webjars/**").permitAll();
        httpSecurity.rememberMe();
//        httpSecurity.authorizeRequests().requestMatchers("/user/**").hasRole("USER");
//        httpSecurity.authorizeRequests().requestMatchers("/admin/**").hasRole("ADMIN");
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
        httpSecurity.userDetailsService(userDetailServiceImpl);
        return httpSecurity.build();
    }
}

