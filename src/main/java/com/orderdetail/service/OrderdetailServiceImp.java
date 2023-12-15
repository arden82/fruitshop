package com.orderdetail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.CreateOrderReq;
import com.Flist;
import com.orderdetail.model.OrderdetailDAO;
import com.orderdetail.model.OrderdetailVO;
import com.orderitem.model.OrderitemVO;
import com.product.model.ProductDAO;
import com.product.model.ProductVO;

@Component
public class OrderdetailServiceImp implements OrderdetailService {
	@Autowired
	private OrderdetailDAO orderdetailDAO;
	@Autowired
	private ProductDAO productDAO;

	@Transactional
	@Override
	public Integer creatOrder(CreateOrderReq createOrderReq) {
		int total = 0;
		List<OrderitemVO> Orderitemlist = new ArrayList<>();
		for (Flist flist : createOrderReq.getFlist()) {
			ProductVO productVO = productDAO.getById(flist.getId());
			
			productDAO.update(productVO.getId(),productVO.getTotalQquantity()-flist.getQuantity());
			int sum = flist.getQuantity() * productVO.getPrice();
			total += sum;
			OrderitemVO orderitemVO=new OrderitemVO();
			orderitemVO.setProductId(flist.getId());
			orderitemVO.setQuantity(flist.getQuantity());
			orderitemVO.setAmount(sum);
			Orderitemlist.add(orderitemVO);
			
		}
		Integer orderdetailid = orderdetailDAO.creatOrder(createOrderReq.getUsername(), total);
		orderdetailDAO.creatOrderItem(orderdetailid,Orderitemlist);
		return orderdetailid;
	}

	@Override
	public OrderdetailVO getOrderById(Integer orderid) {
		OrderdetailVO orderdetailVO=orderdetailDAO.getOrderById(orderid);
		List<OrderitemVO> orderitemVOlist=orderdetailDAO.getOrderitemById(orderid);
		 orderdetailVO.setOrderitemVOlist(orderitemVOlist);
		return  orderdetailVO;
	}

}
