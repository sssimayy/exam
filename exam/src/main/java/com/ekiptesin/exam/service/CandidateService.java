package com.ekiptesin.exam.service;

import com.ekiptesin.exam.entity.Candidate;
import com.ekiptesin.exam.results.DataResult;
import com.ekiptesin.exam.results.Result;
import com.ekiptesin.exam.results.SuccessDataResult;

import java.util.List;
import java.util.Optional;

public interface CandidateService {

    Result add(Candidate candidate);

    DataResult<List<Candidate>> getAll();

    SuccessDataResult<Optional<Candidate>> getCandidateById(Long id);

    void deleteCandidateById(Long id);

    Candidate updateCandidateById(Candidate candidate);

    Result changeStatus(Long id);
}
