package com.gmail.khitirinikoloz.loanmanager.controller;

import com.gmail.khitirinikoloz.loanmanager.dto.LoanApplicationDTO;
import com.gmail.khitirinikoloz.loanmanager.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanApplicationController {
    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping("/")
    public ResponseEntity<LoanApplicationDTO> create(@Valid @RequestBody LoanApplicationDTO loanApplicationDTO) {
        return new ResponseEntity<>(loanApplicationService.registerApplication(loanApplicationDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanApplicationDTO> get(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(loanApplicationService.getLoanApplication(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanApplicationDTO>> getAll() {
        return new ResponseEntity<>(loanApplicationService.getAllApplications(), HttpStatus.OK);
    }

    @GetMapping("/field/{field}/sort/{strategy}")
    public ResponseEntity<List<LoanApplicationDTO>> getAll(@PathVariable("field") final String field,
                                                           @PathVariable("strategy") final String strategy) {
        return new ResponseEntity<>(loanApplicationService.getAllSortedApplications(field, strategy), HttpStatus.OK);
    }

}
