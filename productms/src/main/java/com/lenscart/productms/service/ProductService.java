package com.lenscart.productms.service;

import com.lenscart.productms.constants.ProductType;
import com.lenscart.productms.dto.AddProductRequest;
import com.lenscart.productms.dto.ProductDetails;
import com.lenscart.productms.dto.RemoveProductRequest;
import com.lenscart.productms.dto.UpdateProductRequest;
import com.lenscart.productms.entity.Products;
import com.lenscart.productms.exceptions.InvalidProductDataException;
import com.lenscart.productms.exceptions.InvalidProductTypeException;
import com.lenscart.productms.exceptions.ProductNotFoundException;
import com.lenscart.productms.repository.IProductRepository;
import com.lenscart.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repository;

    @Autowired
    private ProductUtil util;

    @Override
    public ProductDetails addProduct(@NotNull @Valid AddProductRequest addRequest) throws InvalidProductTypeException{
        Products product = new Products();
        product.setName(addRequest.getName());
        product.setPrice(addRequest.getPrice());
        product.setBrand(addRequest.getBrand());

        String type = addRequest.getType();
        ProductType jobType = util.toEnum(type);
        product.setType(jobType);

        product.setDescription(addRequest.getDescription());
        product.setColour(addRequest.getColour());
        product.setShape(addRequest.getShape());
        product.setPower(addRequest.getPower());
        product = repository.save(product);

        return util.toProductDetails(product);
    }

    @Override
    public void removeProduct(RemoveProductRequest removeRequest) throws ProductNotFoundException{
            try {
                repository.deleteById(removeRequest.getId());
            } catch (Exception e) {
                throw new ProductNotFoundException("No such product exists");
            }
    }

    @Override
    public ProductDetails updateProduct(UpdateProductRequest updateRequest)
            throws InvalidProductDataException, ProductNotFoundException{

        if (updateRequest.getPrice() <= 0) {
            throw new InvalidProductDataException("Product price should be greater than 0 ");
        }
        Products product = getProductById(updateRequest.getId());
        product.setPrice(updateRequest.getPrice());
        repository.save(product);
        return util.toProductDetails(product);
    }

    @Override
    public Products getProductById(Long id) throws ProductNotFoundException{
        try {
            Products product = repository.findById(id).get();
            return product;
        } catch (Exception e) {
            throw new ProductNotFoundException("Enter correct Product Id");
        }
    }

    @Override
    public List<ProductDetails> getAllProducts(){
        List<Products> products= repository.findAll();
        List<ProductDetails>details=util.toListProductDetail(products);
        return details;

    }
}
