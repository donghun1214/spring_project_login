package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.loginMemberForm;
import com.example.demo.Domain.Member;
import com.example.demo.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class signInController {

    private final MemberService memberService;
    public signInController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/sign_in")
    public String signIn(){
        return "sign_in";
    }

    @PostMapping("/sign_in")
    public String signIn(loginMemberForm form, HttpSession session){
        Member result = memberService.sign_in(form); //login 해서 꺼내온 member정보를 DTO 정보에 맞게 맞추자. 또 다른 DOMAIN을 만들 수는 없기에.
        if(result != null){
            session.setAttribute("name", result.getName()); //session 정보를 저장.
            return "redirect:/main";
        } else{
            return "redirect:/sign_in";
        }
    }
}
