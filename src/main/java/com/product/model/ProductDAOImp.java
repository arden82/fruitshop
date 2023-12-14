package com.product.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImp implements ProductDAO {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Override
	public int insert(ProductVO entity) {

		return 0;
	}

	@Override
	public int update(ProductVO entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductVO getById(Integer id) {
		String sql = "SELECT id,productname,unit,price,TotalQquantity FROM product WHERE id=:id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		List<ProductVO> productlist = jdbc.query(sql, map, new ProductRowMapper());
		if (productlist.size() > 0) {
			return productlist.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<ProductVO> getProductList() {
		String sql = "SELECT id,productname,unit,price,TotalQquantity FROM product";
		Map<String, Object> map = new HashMap<>();
		List<ProductVO> productlist = jdbc.query(sql, map, new ProductRowMapper());
		return  productlist;
	}

}
