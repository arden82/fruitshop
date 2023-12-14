package com.product.model;

import java.util.List;

public interface ProductDAO {

	int insert(ProductVO entity);

	int update(ProductVO entity);

	int del(Integer id);

	ProductVO getById(Integer id);

	List<ProductVO> getProductList();

}
