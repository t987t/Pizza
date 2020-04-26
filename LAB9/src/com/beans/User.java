package com.beans;

import com.controller.Order;

public class User {
	String name,address;
	String phone_number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phoneno) {
		this.phone_number = phoneno;
	}
	public Order getCurrent_order() {
		return current_order;
	}
	public void setCurrent_order(Order current_order) {
		this.current_order = current_order;
	}
	Order current_order;
}
