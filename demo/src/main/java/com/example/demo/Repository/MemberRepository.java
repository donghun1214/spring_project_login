package com.example.demo.Repository;

import java.util.Optional;

import com.example.demo.Domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long saveId);
    Optional<Member> findByLoginId(String loginId);
}
