package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Investor {
    @Id
    @SequenceGenerator(
            name = "investor_sequence",
            sequenceName = "investor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "investor_sequence"
    )
    private Long investorId;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    @Transient
    private Integer age;
    private String address;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "investor")
    private List<WithdrawalNotice> withdrawalNotices;

    @OneToMany(mappedBy = "investor")
    private List<Product> products;  // Updated field name and type

    // Default constructor
    public Investor() {
    }

    public Investor(Long investorId, String firstname, String lastname, LocalDate dob, String address, String email, String phoneNumber) {
        this.investorId = investorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Investor(String firstname, String lastname, LocalDate dob, String address, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // Calculate the age dynamically based on the dob
    public Integer getAge() {
        if (dob != null) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(dob, currentDate).getYears();
        }
        return null;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "investorId=" + investorId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
