package com.example.demo.Service;


import com.example.demo.DTO.loginMemberForm;
import com.example.demo.Domain.Member;
import com.example.demo.Repository.MemberRepository;
import java.util.Optional;

import jakarta.transaction.Transactional;

@Transactional
public class MemberService {

    //MemberRepository 가 인터페이스임.
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByLoginId(member.getLoginId())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    public Member sign_in(loginMemberForm form){
        Optional<Member> byLoginId = memberRepository.findByLoginId(form.getLoginId()); //DB에서 LoginID를 찾는다. 
        if(byLoginId.isPresent()){
            Member member = byLoginId.get();
            if(member.getPwd().equals(form.getPwd())){
                return member;
            }
            else{
                return null;
            }
        } else{
            return null;
        }
    }
}
