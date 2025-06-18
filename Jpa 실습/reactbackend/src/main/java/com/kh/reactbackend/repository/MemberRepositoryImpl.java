package com.kh.reactbackend.repository;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
    public EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findMember(String memberId) {
        return Optional.ofNullable(em.find(Member.class, memberId));
    }

    @Override
    public Optional<Member> loginMember(MemberDto.LoginRequest request) {
        String query = "select m from Member as m where m.id = :memberId and m.password = :password";

        return Optional.ofNullable(em.createQuery(query, Member.class)
                .setParameter("memberId", request.getMember_id())
                .setParameter("password", request.getPassword())
                .getSingleResult());
    }
}
