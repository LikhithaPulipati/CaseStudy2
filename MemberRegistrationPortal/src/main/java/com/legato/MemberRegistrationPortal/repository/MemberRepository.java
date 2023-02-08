package com.legato.MemberRegistrationPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legato.MemberRegistrationPortal.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	public Member findAllByEmail(String userName);

}
