package com.itheima.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.OrderUser;
import com.itheima.pojo.Orders;

public class OrderMapperTest {
	
	//查询所有订单条数
	@Test
	public void testFindCountUser() throws IOException{
		String resource= "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从SqlSession中获取接口对象
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> list = orderMapper.findAllOrder();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	
	//查询所有订单信息，关联查询下单用户信息
	@Test
	public void testFindOrdersAndUser() throws IOException{
		String resource= "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从SqlSession中获取接口对象
		/*OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUser> list = orderMapper.findOrdersAndUser();
		for (OrderUser orderUser : list) {
			System.out.println(orderUser);*/
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> list = orderMapper.findOrdersAndUser();
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}
}
