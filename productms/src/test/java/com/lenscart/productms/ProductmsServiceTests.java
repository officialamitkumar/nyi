package com.lenscart.productms;

import com.lenscart.productms.entity.Products;
import com.lenscart.productms.exceptions.ProductNotFoundException;
import com.lenscart.productms.repository.IProductRepository;
import com.lenscart.productms.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductmsServiceTests {

	@InjectMocks
	private ProductService service;

	@Mock
	private IProductRepository repository;

	@InjectMocks
	private Products product;

	@BeforeEach
	public void setUp() {
		product.setId(1L);
		product.setName("Ray Ban Sunglasses");
		product.setBrand("Ray Ban");
		product.setColour("Blue");
		product.setPrice(2000.0);
		product.setDescription("Blue frame with rectangular shape");
		product.setShape("rectangular");
	}
	@Test
	public void testGetFrameById() throws ProductNotFoundException {
		Long id = 1L;
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(product));
		assertEquals(product, service.getProductById(id));
		assertEquals(product.getId(), service.getProductById(id).getId());
	}

}
