package yte.spring_security.spring_security.sequrityWebConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import yte.spring_security.spring_security.service.CustomUserDetailsService;
import yte.spring_security.spring_security.service.UsersDetailsServiceImpl;

@Configuration

public class WebConfiguration {

    public WebConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder, CustomUserDetailsService customUserDetailsService, UsersDetailsServiceImpl usersService) throws Exception {

        //Kendi oluşturduğum şifre ve kullanıcı adı
     /*   UserDetails user = User.builder()
                .username("yusuf")
                .password("123")
                .authorities("READ")
                .build();

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(user)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());*/


        //şifreleme algoritması ile şifreleme // user kelimesi şifreli tutuluyır
      /*  BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
                .authorities("ROLE_USER")
                .build();

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(user)
                .passwordEncoder(passwordEncoder);
*/
/*
        UserDetails user = User.builder().username("yusuf").password("123").authorities("USER").build();
        UserDetails admin = User.builder().username("admin").password("1234").authorities("ADMIN").build();
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(user)
                .withUser(admin)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());*/


        authenticationManagerBuilder
                .userDetailsService(usersService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());


    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .antMatchers("/users").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/admins").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }
}





