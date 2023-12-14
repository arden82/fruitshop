package com.product.model;

public class ProductVO {
	private Integer id;
	private String productname;
	private String unit;
	private Integer price;
	private Integer TotalQquantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTotalQquantity() {
		return TotalQquantity;
	}

	public void setTotalQquantity(Integer totalQquantity) {
		TotalQquantity = totalQquantity;
	}

}
