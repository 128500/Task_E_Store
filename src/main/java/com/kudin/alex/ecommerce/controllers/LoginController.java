package com.kudin.alex.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by KUDIN ALEKSANDR on 07.12.2017.
 */

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String getLoginPage(){
        return "/login";
    }
}
