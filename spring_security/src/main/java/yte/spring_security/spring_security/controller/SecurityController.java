package yte.spring_security.spring_security.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @RequestMapping("/selam")
    public String selam() {
        return "selam";
    }


}
