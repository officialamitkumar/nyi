package com.lenscart.productms.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;

public class UpdateProductRequest {

    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    @Min(1)
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
