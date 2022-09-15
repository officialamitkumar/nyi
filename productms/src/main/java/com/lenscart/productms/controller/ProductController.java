package com.lenscart.productms.controller;

import com.lenscart.productms.dto.AddProductRequest;
import com.lenscart.productms.dto.ProductDetails;
import com.lenscart.productms.dto.RemoveProductRequest;
import com.lenscart.productms.dto.UpdateProductRequest;
import com.lenscart.productms.entity.Products;
import com.lenscart.productms.exceptions.InvalidProductDataException;
import com.lenscart.productms.exceptions.InvalidProductTypeException;
import com.lenscart.productms.exceptions.ProductNotFoundException;
import com.lenscart.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public ProductDetails add(@RequestBody AddProductRequest request) throws InvalidProductDataException, InvalidProductTypeException {
        return service.addProduct(request);
    }

    @GetMapping("/byId/{id}")
    public Products getById(@PathVariable Long id) throws ProductNotFoundException {
        return service.getProductById(id);
    }

    @PutMapping("/update")
    public ProductDetails update(@RequestBody UpdateProductRequest request)
            throws InvalidProductDataException, ProductNotFoundException {
        return service.updateProduct(request);
    }

    @PutMapping("/remove")
    public void remove(@RequestBody RemoveProductRequest request) throws ProductNotFoundException{
        service.removeProduct(request);
    }

    @GetMapping("/all")
    public List<ProductDetails> viewAll(){
        return service.getAllProducts();
    }
}
