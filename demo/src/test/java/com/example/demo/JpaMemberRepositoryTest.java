package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Domain.Member;
import com.example.demo.Repository.MemberRepository;
import com.example.demo.Service.MemberService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    
    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setLoginId("hello");
        member.setPwd("dong");
        member.setName("dong1");

        //When
        Long saveId = memberService.join(member);
    
        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getLoginId(), findMember.getLoginId());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setLoginId("spring");
        Member member2 = new Member();
        member2.setLoginId("spring");
        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}