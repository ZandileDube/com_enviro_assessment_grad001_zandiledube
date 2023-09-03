package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Service;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Investor;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.APRIL;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository;

    @Autowired
  public InvestorService(InvestorRepository investorRepository){
        this.investorRepository = investorRepository;

    }

    public List<Investor> getInvestors(){
        return investorRepository.findAll();
    }

}
