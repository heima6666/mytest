package com.itheima.pojo;

public class OrderUser extends Orders {
	private String username;
	private String address;
	private String sex;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "OrderUser [username=" + username + ", address=" + address + ", sex=" + sex + "]";
	}
	
	
}
