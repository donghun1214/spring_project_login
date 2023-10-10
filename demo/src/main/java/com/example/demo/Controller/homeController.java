package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.MemberForm;
import com.example.demo.Domain.Member;
import com.example.demo.Service.MemberService;

@Controller
public class homeController {
    
    //어떤 REPOSTIORY 를 쓸 지 모르기 때문에 DI 기능을 구현했다.
    private final MemberService memberService;
    public homeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/")
    public String create(MemberForm form){
        Member member = new Member();
        
        member.setLoginId(form.getLoginId());
        member.setPwd(form.getPwd());
        member.setName(form.getName());
        
        memberService.join(member);
        
        return "redirect:/sign_in";
    }
}

/**home url 요청이 들어오면 DispatcherServerlet이 받아서 요청에 맞는 컨트롤러를 조회한다.
 * /에 맞는 컨트롤러를 조회 -> DispatcherServerlet 은 home이라는 정보를 받고, 이를 viewResolver에 넘긴다.
 * viewResolver는 home.html 을 templates 에서 찾을 것.
 */