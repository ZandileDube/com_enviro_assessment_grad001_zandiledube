package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Controller;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Investor;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/investor")
public class InvestorController {
    private final InvestorService investorService;
    @Autowired
    public InvestorController(InvestorService investorService){

        this.investorService =investorService;
    }
    @GetMapping
    public List<Investor> getInvestor(){
        return investorService.getInvestors();
    }
}
