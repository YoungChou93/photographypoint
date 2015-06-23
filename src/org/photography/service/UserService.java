package org.photography.service;

import org.hibernate.HibernateException;
import org.photography.dao.UserDao;
import org.photography.entity.User;

public class UserService {
	
private UserDao dao;
    
	public UserService() {
		dao = new UserDao();
	}
    
	/**
	 * 保存用户（用户注册）
	 * 
	 * @param user
	 * @throws HibernateException
	 */
	
	public void regUser(User user) throws HibernateException {
		dao.save(user);
	}
	
    
	/**
	 * 判断登陆
	 * @param email
	 * @param password
	 * @return
	 */

	public boolean loginUser(String email, String password) {
		
		User user = (User) dao.find("email",email);
		
		if (user != null && password.equals(user.getPassword()))
	    {
			return true;
	    }
			
		return false;

	}
	
	/**
	 * 查找邮箱
	 * @param str
	 * @return
	 */
	
	public boolean findEmail(String str){
		User user = (User) dao.find("email",str);
		if (user != null)
	    {
			return true;
	    }
		return false;		
	}
	
	/**
	 * 查找用户名
	 * @param str
	 * @return
	 */
	
	public boolean findNickname(String str){
		User user = (User) dao.find("nickname",str);
		if (user != null)
	    {
			return true;
	    }
		return false;		
	}
	
	/**
	 * 更新用户 （用户修改信息）
	 * @param user
	 */

	public void modify(User user){
		
		dao.updata(user);
	}

}
