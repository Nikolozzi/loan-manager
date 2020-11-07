package com.gmail.khitirinikoloz.loanmanager.service;

import com.gmail.khitirinikoloz.loanmanager.dto.LoanApplicationDTO;
import com.gmail.khitirinikoloz.loanmanager.model.Client;
import com.gmail.khitirinikoloz.loanmanager.model.LoanApplication;
import com.gmail.khitirinikoloz.loanmanager.model.enums.LoanStatus;
import com.gmail.khitirinikoloz.loanmanager.repository.LoanApplicationRepository;
import com.gmail.khitirinikoloz.loanmanager.util.LoanApplicationHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoanApplicationService {
    private final LoanApplicationRepository loanRepository;
    private final ModelMapper mapper;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanRepository, ModelMapper mapper) {
        this.loanRepository = loanRepository;
        this.mapper = mapper;
    }

    @Transactional
    public LoanApplicationDTO registerApplication(LoanApplicationDTO loanApplicationDTO) {
        LoanApplication newApplication = dtoToEntity(loanApplicationDTO);
        LoanStatus loanStatus = scoreLoanApplication(newApplication);
        newApplication.setStatus(loanStatus);
        return entityToDto(loanRepository.save(newApplication));
    }

    @Transactional(readOnly = true)
    public LoanApplicationDTO getLoanApplication(Long id) {
        LoanApplication loanApplication = loanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Loan application not found for given id: " + id));

        return entityToDto(loanApplication);
    }

    @Transactional(readOnly = true)
    public List<LoanApplicationDTO> getAllApplications() {
        return loanRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<LoanApplicationDTO> getAllSortedApplications(String field, String strategy) {
        List<LoanApplicationDTO> loanApplicationDTOs = new ArrayList<>();
        switch (field) {
            case "amount": {
                if (strategy.toLowerCase().equals("asc")) {
                    loanApplicationDTOs =
                            loanRepository.getAllByOrderByAmountAsc()
                                    .stream()
                                    .map(this::entityToDto).collect(Collectors.toList());
                } else if (strategy.toLowerCase().equals("desc")) {
                    loanApplicationDTOs =
                            loanRepository.getAllByOrderByAmountDesc()
                                    .stream()
                                    .map(this::entityToDto).collect(Collectors.toList());
                }
                break;
            }
            case "term": {
                if (strategy.toLowerCase().equals("asc")) {
                    loanApplicationDTOs =
                            loanRepository.getAllByOrderByTermAsc()
                                    .stream()
                                    .map(this::entityToDto).collect(Collectors.toList());
                } else if (strategy.toLowerCase().equals("desc")) {
                    loanApplicationDTOs =
                            loanRepository.getAllByOrderByTermDesc()
                                    .stream()
                                    .map(this::entityToDto).collect(Collectors.toList());
                }
                break;
            }
            default:
                loanApplicationDTOs = this.getAllApplications();
        }

        return loanApplicationDTOs;
    }

    private LoanStatus scoreLoanApplication(LoanApplication loanApplication) {
        double score = this.getApplicationScore(loanApplication);

        final LoanStatus status;
        if (score < 2500)
            status = LoanStatus.REJECTED;
        else if (score > 3500)
            status = LoanStatus.APPROVED;
        else
            status = LoanStatus.MANUAL;

        return status;
    }

    private double getApplicationScore(LoanApplication loanApplication) {
        Client loanClient = loanApplication.getClient();
        Map<Character, Integer> charPositions = LoanApplicationHelper.getAlphabet();

        String firstName = loanClient.getFirstName().toLowerCase();
        int sumOfFirstNameChars = 0;
        for (int i = 0; i < firstName.length(); i++) {
            sumOfFirstNameChars += charPositions.getOrDefault(firstName.charAt(i), 0);
        }

        double salary = loanClient.getSalary();
        double monthlyLiability = loanClient.getLiability();
        int yearOfBirth = loanClient.getBirthDate().getYear();
        int monthOfBirth = loanClient.getBirthDate().getMonthValue();
        int dayOfBirth = loanClient.getBirthDate().getDayOfYear();

        return sumOfFirstNameChars + salary * 1.5 - monthlyLiability * 3
                + yearOfBirth - monthOfBirth - dayOfBirth;
    }

    private LoanApplicationDTO entityToDto(LoanApplication loanApplication) {
        return mapper.map(loanApplication, LoanApplicationDTO.class);
    }

    private LoanApplication dtoToEntity(LoanApplicationDTO loanApplicationDTO) {
        return mapper.map(loanApplicationDTO, LoanApplication.class);
    }
}
