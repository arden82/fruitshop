package com.orderdetail.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.orderdetail.model.OrderdetailVO;

public class OrderRowMapper implements RowMapper<OrderdetailVO> {

	@Override
	public OrderdetailVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderdetailVO orderdetailVO =new OrderdetailVO();
		orderdetailVO.setIdorderdetail(rs.getInt("idorderdetail"));
		orderdetailVO.setUsername(rs.getString("username"));
		orderdetailVO.setTotal(rs.getInt("total"));
		orderdetailVO.setOrdertime(rs.getTimestamp("ordertime"));
		orderdetailVO.setStatue(rs.getBoolean("statue"));
		return orderdetailVO;
	}

}
