package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
