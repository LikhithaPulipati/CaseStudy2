package com.legato.MemberRegistrationPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.legato.MemberRegistrationPortal.Exception.MemberRegistrationPortalException;
import com.legato.MemberRegistrationPortal.model.Claim;
import com.legato.MemberRegistrationPortal.model.Dependent;
import com.legato.MemberRegistrationPortal.model.LoginPayload;
import com.legato.MemberRegistrationPortal.model.Member;
import com.legato.MemberRegistrationPortal.repository.MemberRepository;
import com.legato.MemberRegistrationPortal.service.ClaimService;
import com.legato.MemberRegistrationPortal.service.MemberService;

@RestController
@CrossOrigin()
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	ClaimService claimService;

	@PostMapping({ "/registerNewMember" })
	public ResponseEntity<Member> registerNewMember(@RequestBody Member member)
			throws MemberRegistrationPortalException {
		Member registeredMember = memberService.registerNewUser(member);
		if (registeredMember != null) {

			return ResponseEntity.ok(registeredMember);
		} else {

			throw new MemberRegistrationPortalException("User already exist");
		}

	}

	@PostMapping({ "/sign-in" })
	public ResponseEntity<Member> loginToSystem(@RequestBody LoginPayload userData) throws Exception {
		String memId = userData.getUserId();
		Member logedInUser = memberRepository.findAllByEmail(memId);
		if (logedInUser != null && userData.getPassword().equals(logedInUser.getPassword())) {
			return ResponseEntity.ok(logedInUser);
		} else
			throw new MemberRegistrationPortalException("Invalid user");

	}

	@PutMapping("/updateMember/{id}")
	public ResponseEntity<Member> updateBook(@PathVariable String id, @RequestBody Member memberDetails) {
		Member memberfromDb = memberRepository.findAllByEmail(id);
		Member member = memberfromDb;
		member.setName(memberDetails.getName());
		member.setAddress(memberDetails.getAddress());
		member.setState(memberDetails.getState());
		member.setCountry(memberDetails.getCountry());
		member.setEmail(memberDetails.getEmail());
		member.setPan(memberDetails.getPan());
		member.setContactNo(memberDetails.getContactNo());
		member.setDob(memberDetails.getDob());
		member.setPassword(memberDetails.getPassword());
		member.setDependentOne(memberDetails.getDependentOne());
		member.setDependentOneDob(memberDetails.getDependentOneDob());
		member.setDependentTwo(memberDetails.getDependentTwo());
		member.setDependentTwoDob(memberDetails.getDependentTwoDob());

		Member updatedMember = memberRepository.save(member);
		return ResponseEntity.ok(updatedMember);

	}

	@GetMapping("/readMember/{id}")
	public Member getMemberById(@PathVariable String id) {
		Member member = memberRepository.findAllByEmail(id);

		return member;
	}

	@PostMapping({ "/addDependent/{mem_id}" })
	public String addDependent(@PathVariable String mem_id, @RequestBody Dependent dependent) throws Exception {
		String memId = mem_id;
		Member logedInUser = memberRepository.findAllByEmail(memId);
		if (logedInUser.getEmail() != null) {
			if (memberService.addDependentData(mem_id, dependent)) {

				return "Dependent saved";
			} else {

				return "Dependents cannot exceed limit";
			}
		}
		return "User does not exist";
		
	}

	@PostMapping("/getClaim/{id}")
	public long getMemberClaim(@PathVariable String id, @RequestBody Claim claimData)
			throws MemberRegistrationPortalException {
		//Member member = memberRepository.findAllByEmail(id);
		long claimToken = claimService.getClaimToken(id, claimData);
		System.out.println(claimToken);

		return claimToken;
	}

}
