package yte.spring_security.spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import yte.spring_security.spring_security.entity.Authority;
import yte.spring_security.spring_security.entity.Users;
import yte.spring_security.spring_security.repository.UserRepository;
import yte.spring_security.spring_security.service.UsersDetailsServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {

        ApplicationContext context = run(SpringSecurityApplication.class, args);


        UserRepository bean = context.getBean(UserRepository.class);

        Users user= new Users(null,"y","1", List.of(new Authority("USER")));
        bean.save(user);

        Users admin= new Users(null,"a","2",List.of(new Authority("ADMIN")));
        bean.save(admin);




    }

}
