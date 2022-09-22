package com.ekiptesin.exam.repository;

import com.ekiptesin.exam.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {



}