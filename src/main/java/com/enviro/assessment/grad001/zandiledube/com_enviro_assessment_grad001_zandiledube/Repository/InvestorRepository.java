package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {

}
