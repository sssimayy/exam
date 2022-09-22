package com.ekiptesin.exam.repository;

import com.ekiptesin.exam.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findById(Long id);



}