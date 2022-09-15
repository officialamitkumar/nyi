package com.lenscart.productms.dto;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

public class RemoveProductRequest {
    @NotNull
    @Min(1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
