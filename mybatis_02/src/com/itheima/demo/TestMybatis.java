package com.itheima.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.pojo.User;

public class TestMybatis {
	
	private SqlSessionFactory sessionFactory = null;
	
	@Before
	public void init() throws IOException{
		//创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建sqlSessionFactory
		sessionFactory = sqlSessionFactoryBuilder.build(in);
		
	}
	
	/**
	 * 根据ID查询用户
	 * @throws IOException 
	 */
	@Test
	public void testFindUserById(){
		//获取session
		SqlSession openSession = sessionFactory.openSession();
		User user = openSession.selectOne("test.findUserById",24);
		System.out.println(user);
	}
	
//	根据用户名称模糊查询用户列表
	@Test
	public void testFindUserListByUsername(){
		SqlSession openSession = sessionFactory.openSession();
		List<User> users = openSession.selectList("test.findUserListByUsername","%明%");
		for (User user : users) {
			System.out.println(user);
		}
	}
	
//	添加用户
	@Test
	public void testAddUser(){
		SqlSession openSession = sessionFactory.openSession();
		User user = new User();
		user.setAddress("上海");
		user.setUsername("唐嫣");
		user.setBirthday(new Date());
		user.setSex("0");
		int insert = openSession.insert("test.addUser", user);
		openSession.commit();
		System.out.println(insert);
	}
	
//	更新用户
	@Test
	public void testUpdateUser(){
		SqlSession openSession = sessionFactory.openSession();
		User user = new User();
		user.setId(25);
		user.setAddress("上海");
		user.setUsername("潘金莲");
		int i = openSession.update("test.updateUser",user);
		openSession.commit();
		System.out.println(i);
	}
	
//	删除用户
	@Test
	public void testdeleteUserById(){
		SqlSession openSession = sessionFactory.openSession();
		int i = openSession.delete("test.deleteUserById",26);
		openSession.commit();
		System.out.println(i);
	}
	
}
