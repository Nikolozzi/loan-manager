package com.gmail.khitirinikoloz.loanmanager.dto;

import com.gmail.khitirinikoloz.loanmanager.model.LoanApplication;

import java.time.LocalDate;
import java.util.List;

public class ClientDTO {
    private Long id;
    private String personalId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Double salary;
    private Double liability;
    private List<LoanApplication> loans;

    public ClientDTO(Long id, String personalId, String firstName, String lastName, String email,
                     String password, LocalDate birthDate, Double salary, Double liability, List<LoanApplication> loans) {
        this.id = id;
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.salary = salary;
        this.liability = liability;
        this.loans = loans;
    }

    public ClientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getLiability() {
        return liability;
    }

    public void setLiability(Double liability) {
        this.liability = liability;
    }

    public List<LoanApplication> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanApplication> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", personalId='" + personalId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", liability=" + liability +
                ", loans=" + loans +
                '}';
    }
}
