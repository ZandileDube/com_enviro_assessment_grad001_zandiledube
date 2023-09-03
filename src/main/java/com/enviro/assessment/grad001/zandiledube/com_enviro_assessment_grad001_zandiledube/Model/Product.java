package com.enviro.assessment.grad001.zandiledube.com_enviro_assessment_grad001_zandiledube.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Product {
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
    private Long productId; // Changed from int to Long
    @Enumerated(EnumType.STRING) // Map the enum to the database column
    private Type productType;
    private String name;
    private double currentBalance;
    @ManyToOne
    @JoinColumn(name = "investorId")
    private Investor investor;

    public Product() {
    }

    public Product(Long productId, Type productType, String name, double currentBalance) {
        this.productId = productId;
        this.productType = productType;
        this.name = name;
        this.currentBalance = currentBalance;
    }

    public Product(Type productType, String name, double currentBalance) {
        this.productType = productType;
        this.name = name;
        this.currentBalance = currentBalance;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Type getProductType() {
        return productType;
    }

    public void setProductType(Type productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productType=" + productType +
                ", name='" + name + '\'' +
                ", currentBalance=" + currentBalance +
                ", investor=" + investor +
                '}';
    }
}
