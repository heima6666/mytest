package com.itheima.mapper;

import java.io.IOException;
import java.util.List;

import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;

public interface UserMapper {
	
	/**
	 * 根据ID查询用户
	 * @throws IOException 
	 */
	public User findUserById(Integer id);
	
	public List<User> findUserListByUsername(String str);
	
	//根据用户名模糊查询用户信息，查询条件放到QueryVo的user属性中
	public List<User> findUserListByUsername(QueryVo queryVo);
	
	//查询用户表数据条数
	public Integer findCountUser();
	
	//根据性别和名字查询用户
	public List<User> findUserBySexAndUsername(User user);
	
	//传入集合或数组
	public List<User> QueryUserByIds(QueryVo queryVo);
	
	//一对多    查询所有用户信息及用户关联的订单信息。
	public List<User> queryUserAndOrders();
}
