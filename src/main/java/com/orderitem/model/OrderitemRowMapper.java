package com.orderitem.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.orderdetail.model.OrderdetailVO;

public class OrderitemRowMapper implements RowMapper<OrderitemVO> {

	@Override
	public OrderitemVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderitemVO orderitemVO=new OrderitemVO();
		orderitemVO.setIdorderitem(rs.getInt("idorderitem"));
		orderitemVO.setIdorderdetail(rs.getInt("idorderdetail"));
		orderitemVO.setProductId(rs.getInt("productid"));
		orderitemVO.setQuantity(rs.getInt("quantity"));
		orderitemVO.setAmount(rs.getInt("amount"));
	
		return orderitemVO;
	}

}
