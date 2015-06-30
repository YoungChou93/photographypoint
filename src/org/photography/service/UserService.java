package org.photography.service;

import java.util.Date;

import org.hibernate.HibernateException;
import org.photography.dao.UserDao;
import org.photography.entity.User;
import org.photography.utils.CommonUtils;
import org.photography.utils.SendMail;

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

		if (!findEmail(user.getEmail()) && !findNickname(user.getNickname())) {
			user.setStatus(false);
			user.setGender(2);
			user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid());
			Date date = new Date();
			user.setRegisterTime(date);
			user.setHead("/file/headpicture/headpicture.jpg");
			dao.save(user);

			// 发送邮件
			SendMail sendMail = new SendMail();
			sendMail.send(user);
		}
	}

	public boolean activateUser(String activationCode) {
		User user = (User) dao.find("activationCode", activationCode);
		if (user != null && !user.isStatus()) {
			user.setStatus(true);
			dao.update(user);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 判断登陆
	 * 
	 * @param email
	 * @param password
	 * @return user 用户
	 */

	public User loginUser(String email, String password) {

		User user = (User) dao.find("email", email);

		if (user != null && password.equals(user.getPassword())) {
			return user;
		}

		return null;

	}

	/**
	 * 通过邮箱查找用户
	 * 
	 * @param str
	 * @return
	 */

	public boolean findEmail(String str) {
		User user = (User) dao.find("email", str);
		if (user != null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 通过激活码查找用户
	 * 
	 * @param str
	 * @return
	 */

	public boolean findActivate(String str) {
		User user = (User) dao.find("activateCode", str);
		if (user != null) {
			return true;
		}
		return false;
	}

	/**
	 * 通过用户名查找用户
	 * 
	 * @param str
	 * @return
	 */
	public boolean findNickname(String str) {
		User user = (User) dao.find("nickname", str);
		if (user != null) {
			return true;
		}
		return false;
	}

	/**
	 * 更新用户 （用户修改信息）
	 * 
	 * @param user
	 */

	public void modify(User user) {
		
		//User findUser = (User) dao.find("activationCode", user.getActivationCode());
      //  findUser=user;
        dao.update(user);
       
	}

}
