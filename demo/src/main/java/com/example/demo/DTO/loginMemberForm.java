package com.example.demo.DTO;

import com.example.demo.Domain.Member;

public class loginMemberForm {
    private String loginId;
    private String pwd;

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static loginMemberForm toMemberDTO(Member member) {
        loginMemberForm memberDTO = new loginMemberForm();
        memberDTO.setLoginId(member.getLoginId());
        memberDTO.setPwd(member.getPwd());
        
        return memberDTO;
    }
}
