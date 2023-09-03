package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class WithdrawalNotice {
    @Id
    @SequenceGenerator(
            name = "notice_sequence",
            sequenceName = "notice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notice_sequence"
    )
    private Long withdrawalNoticeId; // Changed from int to Long
    private double withdrawalAmount;
    private LocalDate noticeDate;
    private String bankingDetails;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "investorId")
    private Investor investor;

    @OneToOne(mappedBy = "withdrawalNotice")
    private Notification notification;

    public WithdrawalNotice() {
    }

    public WithdrawalNotice(Long withdrawalNoticeId, double withdrawalAmount, LocalDate noticeDate, String bankingDetails) {
        this.withdrawalNoticeId = withdrawalNoticeId;
        this.withdrawalAmount = withdrawalAmount;
        this.noticeDate = noticeDate;
        this.bankingDetails = bankingDetails;
    }

    public WithdrawalNotice(double withdrawalAmount, LocalDate noticeDate, String bankingDetails) {
        this.withdrawalAmount = withdrawalAmount;
        this.noticeDate = noticeDate;
        this.bankingDetails = bankingDetails;
    }

    public Long getWithdrawalNoticeId() {
        return withdrawalNoticeId;
    }

    public void setWithdrawalNoticeId(Long withdrawalNoticeId) {
        this.withdrawalNoticeId = withdrawalNoticeId;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public LocalDate getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(LocalDate noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getBankingDetails() {
        return bankingDetails;
    }

    public void setBankingDetails(String bankingDetails) {
        this.bankingDetails = bankingDetails;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    @Override
    public String toString() {
        return "WithdrawalNotice{" +
                "withdrawalNoticeId=" + withdrawalNoticeId +
                ", withdrawalAmount=" + withdrawalAmount +
                ", noticeDate=" + noticeDate +
                ", bankingDetails='" + bankingDetails + '\'' +
                ", product=" + product +
                ", investor=" + investor +
                '}';
    }
}
