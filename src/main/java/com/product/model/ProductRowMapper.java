package com.product.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper  implements RowMapper<ProductVO>{

	@Override
	public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductVO productVO=new ProductVO();
		productVO.setId(rs.getInt("id"));
		productVO.setProductname(rs.getNString("productname"));
		productVO.setUnit(rs.getNString("unit"));
		productVO.setPrice(rs.getInt("price"));
		productVO.setTotalQquantity(rs.getInt("TotalQquantity"));
		return productVO;
	}

}
