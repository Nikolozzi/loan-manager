package com.gmail.khitirinikoloz.loanmanager.repository;

import com.gmail.khitirinikoloz.loanmanager.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

}
