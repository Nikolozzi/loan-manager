package com.gmail.khitirinikoloz.loanmanager.repository;

import com.gmail.khitirinikoloz.loanmanager.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
    List<LoanApplication> getAllByOrderByAmountAsc();
    List<LoanApplication> getAllByOrderByAmountDesc();

    List<LoanApplication> getAllByOrderByTermAsc();
    List<LoanApplication> getAllByOrderByTermDesc();
}
