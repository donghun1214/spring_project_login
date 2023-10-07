package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class signInController {

    @GetMapping("/sign_in")
    public String signIn(){
        return "sign_in";
    }
}
