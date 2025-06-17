package com.bd.sitebd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/logout-sucesso")
    public String logoutSuccess() {
        return "logout-sucesso"; // Nome do arquivo HTML (ex: logout-sucesso.html em templates)
    }

    }
