package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Service;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Product;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository ){
        this.productRepository= productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
