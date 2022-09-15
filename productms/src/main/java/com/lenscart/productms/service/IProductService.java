package com.lenscart.productms.service;

import com.lenscart.productms.dto.AddProductRequest;
import com.lenscart.productms.dto.ProductDetails;
import com.lenscart.productms.dto.RemoveProductRequest;
import com.lenscart.productms.dto.UpdateProductRequest;
import com.lenscart.productms.entity.Products;
import com.lenscart.productms.exceptions.InvalidProductDataException;
import com.lenscart.productms.exceptions.InvalidProductTypeException;
import com.lenscart.productms.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public interface IProductService {
    public ProductDetails addProduct(@NotNull @Valid AddProductRequest addRequest) throws InvalidProductTypeException;

    public void removeProduct(@Valid RemoveProductRequest removeRequest) throws ProductNotFoundException;

    public ProductDetails updateProduct(@Valid UpdateProductRequest updateRequest) throws InvalidProductDataException, ProductNotFoundException;

    public Products getProductById(@Min(1) Long id) throws ProductNotFoundException;

    public List<ProductDetails> getAllProducts();
}
