package com.legato.MemberRegistrationPortal.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legato.MemberRegistrationPortal.Exception.MemberRegistrationPortalException;
import com.legato.MemberRegistrationPortal.model.Dependent;
import com.legato.MemberRegistrationPortal.model.Member;
import com.legato.MemberRegistrationPortal.repository.DependentRepository;
import com.legato.MemberRegistrationPortal.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private DependentRepository dependentRepository;

	@Override
	public Optional<Member> findById(Integer id) {

		return memberRepository.findById(id);
	}

	@Override
	public Member save(Member member) {

		return memberRepository.save(member);
	}

	@Override
	public Member update(Member member) {
		if (member.getName() == null)
			throw new NullPointerException("Memeber not found, ID is required for update the data");

		return memberRepository.saveAndFlush(member);
	}

	public Member registerNewUser(Member member) throws MemberRegistrationPortalException {
		System.out.println(member.getId());
		Member registryMember = memberRepository.findAllByEmail(member.getEmail());
		System.out.println(registryMember);
		if (registryMember != null) {
			throw new MemberRegistrationPortalException("User already exists");
		} else {
			Member memberFromDb = memberRepository.save(member);
			Random random = new Random();
			int mem_gen_id = random.nextInt(900) + 100;
			System.out.println(mem_gen_id);
			memberFromDb.setMemberId("MEM_" + mem_gen_id);
			System.out.println("User Saved Successfully");
			return memberRepository.save(memberFromDb);

		}

	}

	public boolean addDependentData(String userName, Dependent dependent) {
		List<Optional<Dependent>> mem_dependent_list = dependentRepository.findAllByUserId(userName);
		long count_dpnts = mem_dependent_list.stream().count();
		if (count_dpnts < 2) {
			System.out.println(count_dpnts);
			dependentRepository.save(dependent);
			return true;
		} else {
			return false;
		}
	}

}
