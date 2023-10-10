package com.example.demo.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGINID") //JPA 가 자동으로 LOGIN_ID 로 맵핑을 해주기 때문에 Column을 따로 설정해줘야 된다.
    private String loginId;
    
    private String pwd;
    private String name;

    //ID 는 안 건들여도 된다.
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
