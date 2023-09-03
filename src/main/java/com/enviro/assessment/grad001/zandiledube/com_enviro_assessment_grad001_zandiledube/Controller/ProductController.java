package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Controller;

import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model.Product;
import com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (path="api/v1/product")

public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){

        this.productService = productService;
    }
    @GetMapping
    public List<Product> getProduct() {
        return productService.getProducts();
    }


}
