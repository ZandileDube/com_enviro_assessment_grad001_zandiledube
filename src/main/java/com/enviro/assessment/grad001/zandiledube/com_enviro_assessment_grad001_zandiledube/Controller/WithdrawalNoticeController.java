package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Controller;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.WithdrawalNotice;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Service.WithdrawalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/withdrawalNotice")
public class WithdrawalNoticeController {
private final WithdrawalNoticeService withdrawalNoticeService;
    @Autowired
    public WithdrawalNoticeController(WithdrawalNoticeService withdrawalNoticeService) {
        this.withdrawalNoticeService = withdrawalNoticeService;
    }

    //Create a new withdrawal notice
    @PostMapping
    public  ResponseEntity<String> createWithdrawalNotice(@RequestBody WithdrawalNotice withdrawalNotice ) {
        try{
            WithdrawalNotice createNotice = withdrawalNoticeService.createWithdrawalNotice(withdrawalNotice);
            return ResponseEntity.status(HttpStatus.CREATED).body("Withdrawal notice created successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create withdrawal notice: " + e.getMessage());
        }
    }
}
