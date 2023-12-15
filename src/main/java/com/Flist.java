package com;

import javax.validation.constraints.NotNull;

public class Flist {
	@NotNull
	private String productname;
	@NotNull
	private Integer quantity;
	@NotNull
	private Integer id;

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
