package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.OrderUser;
import com.itheima.pojo.Orders;

//订单
public interface OrderMapper {
	
	//查询所有订单表的数据
	public List<Orders> findAllOrder();
	
	//查询所有订单信息，关联查询下单用户信息
	public List<Orders> findOrdersAndUser();
}
