package com.gmail.khitirinikoloz.loanmanager.controller;


import com.gmail.khitirinikoloz.loanmanager.dto.OperatorDTO;
import com.gmail.khitirinikoloz.loanmanager.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/operator")
public class OperatorController {
    private final OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<OperatorDTO> create(@Valid @RequestBody final OperatorDTO operatorDTO) {
        return new ResponseEntity<>(operatorService.register(operatorDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperatorDTO> get(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(operatorService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<OperatorDTO>> getAll() {
        return new ResponseEntity<>(operatorService.getAll(), HttpStatus.OK);
    }
}
