package com.leantech.expert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leantech.expert.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{
	
}
