package com.ekiptesin.exam.contoller;

import com.ekiptesin.exam.entity.Candidate;
import com.ekiptesin.exam.results.DataResult;
import com.ekiptesin.exam.results.Result;
import com.ekiptesin.exam.results.SuccessDataResult;
import com.ekiptesin.exam.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public Result addCandidate(@RequestBody Candidate candidate) {
        return candidateService.add(candidate);
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll() {

        return candidateService.getAll();
    }

    @GetMapping("/getCandidateById")
    public SuccessDataResult<Optional<Candidate>> findAllByIsActiveAndCompanyName(Long id) {
        return this.candidateService.getCandidateById(id);
    }

    @DeleteMapping("/deleteCandidate/{id}")
    public void deleteCandidateById(@PathVariable("id") Long id) {
        this.candidateService.deleteCandidateById(id);
    }

    @PutMapping("/updateCandidate/{id}")
    public Candidate updateCandidateById(@RequestBody Candidate candidate) {
        return this.candidateService.updateCandidateById(candidate);
    }

    @PostMapping("/changeStatus")
    public Result changeStatus(Long id) {
        return this.candidateService.changeStatus(id);
    }
}
