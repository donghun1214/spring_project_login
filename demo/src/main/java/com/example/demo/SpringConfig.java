package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Repository.JpaBoardRepository;
import com.example.demo.Repository.JpaMemberRepository;
import com.example.demo.Repository.MemberRepository;
import com.example.demo.Service.BoardService;
import com.example.demo.Service.MemberService;

import javax.sql.DataSource;
import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }

    @Bean
    public JpaBoardRepository boardRepository(){
        return new JpaBoardRepository(em);
    }
}

//https://github.com/codingrecipe1/board
