package com;

import java.util.List;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class CreateOrderReq {
	@NotBlank
	private String username;
	  @NotNull
	private List<Flist> flist;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Flist> getFlist() {
		return flist;
	}

	public void setFlist(List<Flist> flist) {
		this.flist = flist;
	}

}
