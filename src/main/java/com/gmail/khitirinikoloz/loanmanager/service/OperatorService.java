package com.gmail.khitirinikoloz.loanmanager.service;

import com.gmail.khitirinikoloz.loanmanager.dto.OperatorDTO;
import com.gmail.khitirinikoloz.loanmanager.model.Operator;
import com.gmail.khitirinikoloz.loanmanager.repository.OperatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperatorService {
    private final OperatorRepository operatorRepository;
    private final ModelMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public OperatorService(OperatorRepository operatorRepository, ModelMapper mapper) {
        this.operatorRepository = operatorRepository;
        this.mapper = mapper;
    }

    @Transactional
    public OperatorDTO register(OperatorDTO operatorDTO) {
        operatorDTO.setPassword(passwordEncoder.encode(operatorDTO.getPassword()));
        return entityToDto(operatorRepository.save(dtoToEntity(operatorDTO)));
    }

    @Transactional(readOnly = true)
    public OperatorDTO getById(Long id) {
        Operator operator = operatorRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Operator was not found for given id: " + id));
        return entityToDto(operator);
    }

    @Transactional(readOnly = true)
    public List<OperatorDTO> getAll() {
        return operatorRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private OperatorDTO entityToDto(Operator operator) {
        return mapper.map(operator, OperatorDTO.class);
    }

    private Operator dtoToEntity(OperatorDTO operatorDTO) {
        return mapper.map(operatorDTO, Operator.class);
    }
}
