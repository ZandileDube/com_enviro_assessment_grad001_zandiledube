package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Notification {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long notificationId;
    private String message;
    private double balanceBeforeWithdrawal;
    private double amountWithdrawn;
    private double closingBalance;

    @OneToOne
    @JoinColumn(name = "withdrawalNoticeId")
    private WithdrawalNotice withdrawalNotice;

}
