package com.orderdetail.service;

import com.CreateOrderReq;
import com.orderdetail.model.OrderdetailVO;

public interface OrderdetailService {
Integer creatOrder(CreateOrderReq  createOrderReq);
OrderdetailVO getOrderById(Integer orderid);
}
