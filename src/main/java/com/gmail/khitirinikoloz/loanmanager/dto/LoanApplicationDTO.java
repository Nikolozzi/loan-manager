package com.gmail.khitirinikoloz.loanmanager.dto;

import com.gmail.khitirinikoloz.loanmanager.model.Client;
import com.gmail.khitirinikoloz.loanmanager.model.enums.LoanStatus;

import java.util.Objects;

public class LoanApplicationDTO {

    private Long id;
    private Client client;
    private Double amount;
    private Long term;
    private LoanStatus status;

    public LoanApplicationDTO(Long id, Client client, Double amount, Long term, LoanStatus status) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.term = term;
        this.status = status;
    }

    public LoanApplicationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoanApplicationDTO{" +
                "id=" + id +
                ", client=" + client +
                ", amount=" + amount +
                ", term=" + term +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanApplicationDTO)) return false;
        LoanApplicationDTO that = (LoanApplicationDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(client, that.client) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(term, that.term) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, amount, term, status);
    }
}
