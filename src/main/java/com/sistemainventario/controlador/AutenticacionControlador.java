package com.sistemainventario.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutenticacionControlador {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
