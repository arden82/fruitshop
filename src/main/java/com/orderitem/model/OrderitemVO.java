package com.orderitem.model;

public class OrderitemVO {
	private Integer idorderitem;
	private Integer idorderdetail;
	private Integer productId;
	private Integer quantity;
	private Integer amount;

	public Integer getIdorderitem() {
		return idorderitem;
	}

	public void setIdorderitem(Integer idorderitem) {
		this.idorderitem = idorderitem;
	}

	public Integer getIdorderdetail() {
		return idorderdetail;
	}

	public void setIdorderdetail(Integer idorderdetail) {
		this.idorderdetail = idorderdetail;
	}


	

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
