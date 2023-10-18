package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.MemberForm;
import com.example.demo.Domain.Member;
import com.example.demo.Service.MemberService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class memberController {
    
    private final MemberService memberService;
    public memberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/update")
    public String update(HttpSession session, Model model){
        String loginId = (String) session.getAttribute("loginId");
        Member member = memberService.updateForm(loginId);
        model.addAttribute("updateMember", member);
        return "member/update";
    }

    @PostMapping("/update")
    public String update(MemberForm form, HttpSession session) {
        Member member = new Member();
        
        member.setId(form.getId());
        member.setLoginId(form.getLoginId());
        member.setPwd(form.getPwd());
        member.setName(form.getName());
        
        memberService.update(member);
        session.setAttribute("name", member.getName());
        return "redirect:/board/main";
    }
}
