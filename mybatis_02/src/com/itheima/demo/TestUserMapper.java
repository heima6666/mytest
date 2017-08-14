package com.itheima.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;

public class TestUserMapper {
	
	@Test
	public void testFindUserById() throws IOException{
		String resource= "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从SqlSession中获取接口对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//创建QueryVo对象
		QueryVo qv = new QueryVo();
		
		User user = new User();
		user.setUsername("张");
		
		qv.setUser(user);
		
		//调用
		List<User> list = userMapper.findUserListByUsername(qv);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}

	@Test
	public void testFindCountUser() throws IOException{
		String resource= "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从SqlSession中获取接口对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer i = userMapper.findCountUser();
		System.out.println(i);
	}
	
	@Test
	public void TestFindUserBySexAndUsername() throws IOException{
		String resource= "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从SqlSession中获取接口对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		//user.setUsername("张");
		List<User> list = userMapper.findUserBySexAndUsername(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
		
	}
	
	@Test
	public void TestQueryUserByIds() throws IOException{
		String resource= "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从SqlSession中获取接口对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(25);
		list.add(16);
		queryVo.setIds(list);		
		//
		List<User> list2 = userMapper.QueryUserByIds(queryVo);
		for (User user : list2) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void TestQueryUserAndOrders() throws IOException{
		String resource= "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从SqlSession中获取接口对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.queryUserAndOrders();
		for (User user : list) {
			System.out.println(user);
		}
	}
}	
