package com.gmail.khitirinikoloz.loanmanager.service;

import com.gmail.khitirinikoloz.loanmanager.dto.ClientDTO;
import com.gmail.khitirinikoloz.loanmanager.model.Client;
import com.gmail.khitirinikoloz.loanmanager.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public ClientService(ClientRepository clientRepository, ModelMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Transactional
    public ClientDTO register(ClientDTO clientDTO) {
        clientDTO.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
        return entityToDto(clientRepository.save(dtoToEntity(clientDTO)));
    }

    @Transactional(readOnly = true)
    public ClientDTO getById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Client was not found for given id: " + id));
        return entityToDto(client);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private ClientDTO entityToDto(Client client) {
        return mapper.map(client, ClientDTO.class);
    }

    private Client dtoToEntity(ClientDTO clientDTO) {
        return mapper.map(clientDTO, Client.class);
    }
}
