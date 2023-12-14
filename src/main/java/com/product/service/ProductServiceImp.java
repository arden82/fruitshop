package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.model.ProductDAO;
import com.product.model.ProductVO;

@Component
public class ProductServiceImp implements ProductService  {

	@Autowired
	private ProductDAO productDAO;
	
	
	@Override
	public List<ProductVO> getproductlist() {
		return productDAO.getProductList();
	}


	@Override
	public ProductVO getById(Integer id) {
		return  productDAO.getById(id);
	}
	

}
