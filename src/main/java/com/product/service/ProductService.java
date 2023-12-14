package com.product.service;

import java.util.List;

import com.product.model.ProductVO;

public interface ProductService {
	public ProductVO getById(Integer id);
	public List<ProductVO> getproductlist();
}
