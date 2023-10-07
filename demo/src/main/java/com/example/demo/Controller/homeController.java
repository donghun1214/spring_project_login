package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.MemberForm;

@Controller
public class homeController {
    
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/")
    public String create(MemberForm form){
        
        return "redirect:/";
    }
}

/**home url 요청이 들어오면 DispatcherServerlet이 받아서 요청에 맞는 컨트롤러를 조회한다.
 * /에 맞는 컨트롤러를 조회 -> DispatcherServerlet 은 home이라는 정보를 받고, 이를 viewResolver에 넘긴다.
 * viewResolver는 home.html 을 templates 에서 찾을 것.
 */