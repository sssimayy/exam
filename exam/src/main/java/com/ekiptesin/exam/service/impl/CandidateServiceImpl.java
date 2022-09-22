package com.ekiptesin.exam.service.impl;

import com.ekiptesin.exam.entity.Candidate;
import com.ekiptesin.exam.repository.CandidateRepository;
import com.ekiptesin.exam.results.*;
import com.ekiptesin.exam.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Result add(Candidate candidate) {
        if (!checkNullArea(candidate)) {
            return new ErrorResult("You have entered missing information. Please fill in all fields.");
        }
        candidateRepository.saveAndFlush(candidate);

        return new SuccessResult("Candidate has been added.");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateRepository.findAll(), "Data listed successfully");
    }

    @Override
    public SuccessDataResult<Boolean> getCandidateById(Long id) {
        return new SuccessDataResult<>(this.candidateRepository.existsById(id));
    }

    @Override
    public void deleteCandidateById(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public Candidate updateCandidateById(Candidate candidate) {
        return candidateRepository.saveAndFlush(candidate);
    }

    @Override
    public Result changeStatus(Long id) {
        if (!this.candidateRepository.existsById(id)) {
            return new ErrorDataResult<Candidate>("There is no such Candidate");

        }

        Candidate candidate = this.candidateRepository.getOne(id);
        candidate.setOpen(false);

        return new SuccessDataResult<Candidate>(this.candidateRepository.save(candidate), "Status has been successfully closed.");
    }

    private boolean checkNullArea(Candidate candidate) {
        if (candidate.getName() != null && candidate.getSurname() != null && candidate.getEmail() != null && candidate.isOpen() != false) {
            return true;
        }
        return false;
    }
}
