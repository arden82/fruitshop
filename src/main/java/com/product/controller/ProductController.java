package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.ProductVO;
import com.product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity <List<ProductVO>> getProductList(){
		List<ProductVO> productlist= productService.getproductlist();
		return ResponseEntity.status(HttpStatus.OK).body(productlist);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductVO> getById(@PathVariable Integer id){
		ProductVO productVO=productService.getById(id);
		if(productVO!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(productVO);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
