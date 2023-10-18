package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.MemberForm;
import com.example.demo.Domain.Member;
import com.example.demo.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class signInController {

    private final MemberService memberService;
    public signInController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/sign_in")
    public String signIn(){
        return "member/sign_in";
    }

    @PostMapping("/sign_in")
    public String signIn(MemberForm form, HttpSession session){
        Member result = memberService.sign_in(form); //login 해서 꺼내온 member정보를 DTO 정보에 맞게 맞추자. 또 다른 DOMAIN을 만들 수는 없기에.
        if(result != null){
            session.setAttribute("name", result.getName()); //session 정보를 저장.
            session.setAttribute("loginId", result.getLoginId());
            return "redirect:/board/main";
        } else{
            return "redirect:/member/sign_in";
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.invalidate();
        return "member/sign_in";
    }
}
