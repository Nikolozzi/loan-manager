package com.gmail.khitirinikoloz.loanmanager.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, length = 11, nullable = false)
    private String personalId;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private Double salary;
    @Column(nullable = false)
    private Double liability;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<LoanApplication> loans;

    public Client() {
    }

    public Client(String personalId, String firstName, String lastName, String email, String password,
                  LocalDate birthDate, Double salary, Double liability, List<LoanApplication> loans) {
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

    public Long getId() {
        return id;
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
        return "Client{" +
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
