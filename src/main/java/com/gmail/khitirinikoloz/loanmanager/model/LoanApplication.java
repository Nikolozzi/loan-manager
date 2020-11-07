package com.gmail.khitirinikoloz.loanmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gmail.khitirinikoloz.loanmanager.model.enums.LoanStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Long term; //days

    private LoanStatus status;

    public Long getId() {
        return id;
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
        return "LoanApplication{" +
                "id=" + id +
                ", client=" + client +
                ", amount=" + amount +
                ", term=" + term +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanApplication)) return false;
        LoanApplication that = (LoanApplication) o;
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
