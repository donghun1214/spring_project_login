package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    
    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
