package com.lenscart.productms.util;

import com.lenscart.productms.constants.ProductType;
import com.lenscart.productms.dto.ProductDetails;
import com.lenscart.productms.entity.Products;
import com.lenscart.productms.exceptions.InvalidProductTypeException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductUtil {

    public ProductDetails toProductDetails(Products products) {
        ProductDetails desired = new ProductDetails();
        desired.setName(products.getName());
        desired.setBrand(products.getBrand());
        desired.setDescription(products.getDescription());
        desired.setPrice(products.getPrice());
        desired.setPower(products.getPower());
        return desired;
    }

    public List<ProductDetails> toListProductDetail(Collection<Products> products){
        return products.stream().
                map(product->toProductDetails(product)).collect(Collectors.toList());
    }

    public ProductType toEnum(String typeText) throws InvalidProductTypeException {
        ProductType values[] = ProductType.values();
        for(ProductType iterated : values) {
            String iteratedText = iterated.toString();
            if(iteratedText.equalsIgnoreCase(typeText)) {
                return iterated;
            }
        }
        throw new InvalidProductTypeException("Product Type is Invalid");
    }

}
