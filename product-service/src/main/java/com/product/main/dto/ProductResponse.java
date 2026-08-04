package com.product.main.dto;

import java.time.LocalDate;

public class ProductResponse {
	private Long productId;
    private String productCode;
    private String productName;
    private String category;
    private Double price;
    private Integer validity;
    private String description;
    private Boolean active;
    private LocalDate createdDate;

    public ProductResponse() {
    }

    public ProductResponse(Long productId, String productCode, String productName,
                           String category, Double price, Integer validity,
                           String description, Boolean active,
                           LocalDate createdDate) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.validity = validity;
        this.description = description;
        this.active = active;
        this.createdDate = createdDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ProductResponse [productId=" + productId +
                ", productCode=" + productCode +
                ", productName=" + productName +
                ", category=" + category +
                ", price=" + price +
                ", validity=" + validity +
                ", description=" + description +
                ", active=" + active +
                ", createdDate=" + createdDate + "]";
    }
}
