package com.gmail.khitirinikoloz.loanmanager.controller;

import com.gmail.khitirinikoloz.loanmanager.dto.ClientDTO;
import com.gmail.khitirinikoloz.loanmanager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/registration")
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody final ClientDTO client) {
        return new ResponseEntity<>(clientService.register(client), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> get(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }
}
