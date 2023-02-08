package com.legato.MemberRegistrationPortal.service;

import java.util.Optional;

import com.legato.MemberRegistrationPortal.Exception.MemberRegistrationPortalException;
import com.legato.MemberRegistrationPortal.model.Dependent;
import com.legato.MemberRegistrationPortal.model.Member;

public interface MemberService {

	Optional<Member> findById(Integer id);

	Member save(Member member);

	Member update(Member member);

	Member registerNewUser(Member member) throws MemberRegistrationPortalException;

	boolean addDependentData(String mem_id, Dependent dependent);

}
