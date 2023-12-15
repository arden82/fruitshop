package com.orderdetail.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.orderdetail.controller.OrderRowMapper;
import com.orderitem.model.OrderitemRowMapper;
import com.orderitem.model.OrderitemVO;

@Component
public class OrderdetailDAOImp implements OrderdetailDAO {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Override
	public Integer creatOrder(String username, Integer total) {
		String sql = "INSERT INTO orderdetail(username,total,ordertime,statue) VALUES (:username,:total,:ordertime,1)";
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("total", total);
		Date now = new Date();
		map.put("ordertime", now);
		KeyHolder keyholder = new GeneratedKeyHolder();
		jdbc.update(sql, new MapSqlParameterSource(map), keyholder);
		int orderdetailid = keyholder.getKey().intValue();
		return orderdetailid;
	}

	@Override
	public void creatOrderItem(Integer orderdetailid, List<OrderitemVO> Orderitemlist) {
		for (OrderitemVO orderitemVO : Orderitemlist) {
			String sql = "INSERT INTO orderitem(idorderdetail,productid,quantity,amount) VALUES (:idorderdetail,:productid,:quantity,:amount)";
			Map<String, Object> map = new HashMap<>();
			map.put("idorderdetail", orderdetailid);
			map.put("productid", orderitemVO.getProductId());
			map.put("quantity", orderitemVO.getQuantity());
			map.put("amount", orderitemVO.getAmount());
			jdbc.update(sql, map);
		}

	}

	@Override
	public OrderdetailVO getOrderById(Integer orderid) {
		String sql = "SELECT idorderdetail,username,total,ordertime,statue FROM orderdetail WHERE idorderdetail=:idorderdetail";
		Map<String, Object> map = new HashMap<>();
		map.put("idorderdetail", orderid);
		List<OrderdetailVO> Orderdetaillist = jdbc.query(sql, map, new OrderRowMapper());
		if (Orderdetaillist.size() > 0) {
			return Orderdetaillist.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<OrderitemVO> getOrderitemById(Integer orderid) {
		String sql = "SELECT idorderitem,idorderdetail,productid,quantity,amount FROM orderitem LEFT JOIN product ON  orderitem.productid = product.id WHERE idorderdetail=:idorderdetail";
		Map<String, Object> map = new HashMap<>();
		map.put("idorderdetail", orderid);
		List<OrderitemVO> Orderitemlist=jdbc.query(sql, map,new OrderitemRowMapper());
		
		
		return Orderitemlist;
	}

}
