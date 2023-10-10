package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.Domain.Member;

import jakarta.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository{
    //Entity Manager : 엔티티를 이용한 DB 작업
    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    
    public Member save(Member member) {
        em.persist(member); //데이터베이스에 저장
        return member; //반환된 객체가 활용되는 용도가 많아서 Member 형을 반환한대.
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public Optional<Member> findByLoginId(String loginId) {
        List<Member> result = em.createQuery("select m from Member m where m.loginId = :loginId",
                            Member.class)
                        .setParameter("loginId", loginId)
                        .getResultList();
                        
        return result.stream().findAny();
    }

}
