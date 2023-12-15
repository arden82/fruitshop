package com.orderdetail.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CreateOrderReq;
import com.orderdetail.model.OrderdetailVO;
import com.orderdetail.service.OrderdetailService;

@RestController
public class OrderdetailController {
	@Autowired
	private OrderdetailService orderdetailService;

	@PostMapping("/order")
	public ResponseEntity<?>creatOrder(@RequestBody @Valid CreateOrderReq  createOrderReq ){
		Integer orderid=orderdetailService.creatOrder(createOrderReq );
		OrderdetailVO orderdetailvo=orderdetailService.getOrderById(orderid);
		return ResponseEntity.status(HttpStatus.OK).body(orderdetailvo);
	}
}
