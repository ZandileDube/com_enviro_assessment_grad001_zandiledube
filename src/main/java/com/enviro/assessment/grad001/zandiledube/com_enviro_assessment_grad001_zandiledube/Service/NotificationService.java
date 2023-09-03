package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Service;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Controller.WithdrawalNoticeController;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Notification;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Product;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.WithdrawalNotice;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService (NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }
    public String generateNotificationMessage(WithdrawalNotice withdrawalNotice) {
        // Generating the notification message with balance details
        double balanceBeforeWithdrawal = withdrawalNotice.getProduct().getCurrentBalance();
        double withdrawalAmount = withdrawalNotice.getWithdrawalAmount();
        double closingBalance = balanceBeforeWithdrawal - withdrawalAmount;

        return "Withdrawal completed:\n" +
                "Date:" + LocalDate.now() + "\n" +
                "Balance before withdrawal: " + balanceBeforeWithdrawal + "\n" +
                "Withdrawal amount: " + withdrawalAmount + "\n" +
                "Closing balance: " + closingBalance;
    }
}



