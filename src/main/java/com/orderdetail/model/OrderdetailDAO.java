package com.orderdetail.model;

import java.util.List;

import com.orderitem.model.OrderitemVO;

public interface OrderdetailDAO {
	Integer creatOrder(String username, Integer total);

	void creatOrderItem(Integer orderdetailid, List<OrderitemVO> Orderitemlist);

	OrderdetailVO getOrderById(Integer orderid);

	List<OrderitemVO> getOrderitemById(Integer orderid);
}
