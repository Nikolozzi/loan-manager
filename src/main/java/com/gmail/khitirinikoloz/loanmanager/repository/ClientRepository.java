package com.gmail.khitirinikoloz.loanmanager.repository;

import com.gmail.khitirinikoloz.loanmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
