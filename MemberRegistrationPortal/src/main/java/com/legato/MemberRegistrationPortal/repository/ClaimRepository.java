package com.legato.MemberRegistrationPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legato.MemberRegistrationPortal.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

	public Claim findAllByEmail(String email);

}
