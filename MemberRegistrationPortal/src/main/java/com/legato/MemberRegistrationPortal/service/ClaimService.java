package com.legato.MemberRegistrationPortal.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legato.MemberRegistrationPortal.model.Claim;
import com.legato.MemberRegistrationPortal.model.Member;
import com.legato.MemberRegistrationPortal.repository.ClaimRepository;
import com.legato.MemberRegistrationPortal.repository.MemberRepository;

@Service
public class ClaimService {
	@Autowired
	ClaimRepository claimRepository;

	@Autowired
	MemberRepository memberRepository;

	public long getClaimToken(String email, Claim claimData) {
		long number = 0;
		Member member = memberRepository.findAllByEmail(email);
		//Claim getMemberClaim = claimRepository.findAllByEmail(email);
		claimData.setUserId(member.getId());
		number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		claimData.setClaimToken(number);
		claimData.setClaimDate(LocalDate.now());
		claimRepository.save(claimData);

		return number;

	}

}
