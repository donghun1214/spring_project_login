package com.example.demo.DTO;


public class MemberForm {
    private String loginId;
    private String pwd;
    private String name;
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginId() {
        return this.loginId;
    }
    public void setloginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
