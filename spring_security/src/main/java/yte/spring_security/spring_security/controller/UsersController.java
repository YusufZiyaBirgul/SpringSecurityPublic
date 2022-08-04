package yte.spring_security.spring_security.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UsersController {

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/admins")
    public String admins() {
        return "admins";
    }
}
