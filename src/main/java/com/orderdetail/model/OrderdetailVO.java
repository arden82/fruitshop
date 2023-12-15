package com.orderdetail.model;

import java.util.Date;
import java.util.List;

import com.orderitem.model.OrderitemVO;

public class OrderdetailVO {
	private Integer idorderdetail;
	private String username;
	private Integer total;
	private Date ordertime;
	private Boolean statue;
	private List<OrderitemVO> orderitemVOlist;

	public Integer getIdorderdetail() {
		return idorderdetail;
	}

	public void setIdorderdetail(Integer idorderdetail) {
		this.idorderdetail = idorderdetail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Boolean getStatue() {
		return statue;
	}

	public void setStatue(Boolean statue) {
		this.statue = statue;
	}

	public List<OrderitemVO> getOrderitemVOlist() {
		return orderitemVOlist;
	}

	public void setOrderitemVOlist(List<OrderitemVO> orderitemVOlist) {
		this.orderitemVOlist = orderitemVOlist;
	}
}
