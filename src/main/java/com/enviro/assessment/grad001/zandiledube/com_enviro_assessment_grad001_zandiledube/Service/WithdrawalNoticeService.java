package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Service;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.*;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository.NotificationRepository;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawalNoticeService {
    private final WithdrawalNoticeRepository withdrawalNoticeRepository;
    private final NotificationService notificationService;

    @Autowired
    public WithdrawalNoticeService(WithdrawalNoticeRepository withdrawalNoticeRepository, NotificationService notificationService) {
    this.withdrawalNoticeRepository=withdrawalNoticeRepository;
    this.notificationService=notificationService;

    }

    //Creating a new withdrawal notice business logic
    public WithdrawalNotice createWithdrawalNotice(WithdrawalNotice withdrawalNotice) {

        double withdrawalAmount = withdrawalNotice.getWithdrawalAmount();
        Product product = withdrawalNotice.getProduct();
        Investor investor = withdrawalNotice.getInvestor();
        // Calculate the maximum allowed withdrawal amount (90% of the current balance)
        double maxAllowedWithdrawal = product.getCurrentBalance() * 0.9;
try {
    // Check if withdrawal amount exceeds the maximum allowed withdrawal
    if (withdrawalAmount > maxAllowedWithdrawal) {
        throw new IllegalArgumentException("Withdrawal amount exceeds the maximum allowed withdrawal limit.");
    }

    // Validating withdrawal amount if greater than current balance
    if (withdrawalAmount > product.getCurrentBalance()) {
        // Respond with a validation error
        throw new IllegalArgumentException("Withdrawal amount exceeds current balance.");
    }

    // Validating if product type is RETIREMENT and investor's age is less than 65
    if (product.getProductType() == Type.RETIREMENT) {
        if (investor.getAge() < 65) {
            // Respond with a validation error
            throw new IllegalArgumentException("Investor's age must be greater than or equal to 65 for RETIREMENT products.");
        }
    }
    // Send the notification to the investor
    String notificationMessage = notificationService.generateNotificationMessage(withdrawalNotice);

    // Saving the withdrawal notice in the WithdrawalNoticeRepository
    return withdrawalNoticeRepository.save(withdrawalNotice);

}catch (Exception e) {
    throw new RuntimeException("Failed to create withdrawal notice: " + e.getMessage(), e);
}



    }



}
