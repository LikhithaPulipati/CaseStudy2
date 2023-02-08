package com.legato.MemberRegistrationPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legato.MemberRegistrationPortal.model.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Integer> {
	public List<Optional<Dependent>> findAllByUserId(String userName);

}
