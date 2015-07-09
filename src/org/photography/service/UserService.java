package org.photography.service;

import java.util.Date;

import org.hibernate.HibernateException;
import org.photography.dao.UserDao;
import org.photography.entity.User;
import org.photography.exception.UserException;
import org.photography.utils.CommonUtils;
import org.photography.utils.SendMail;

/**
 * 用户模块
 * 
 * 业务逻辑层
 * 
 * @author zhouyang
 *
 */
public class UserService {

	private UserDao dao;

	public UserService() {
		dao = new UserDao();
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @throws UserException
	 *
	 */

	public void regUser(User user) throws UserException {

		if (findEmail(user.getEmail())) {
			throw new UserException("邮箱已存在");
		} else if (findNickname(user.getNickname())) {
			throw new UserException("用户名已存在");
		} else {
			user.setStatus(true);// 设置为未激活状态
			user.setGender(2); // 设置为性别未知
			user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid());// 生成激活码
			Date date = new Date();
			user.setRegisterTime(date);// 注册日期
			user.setHead("/file/headpicture/headpicture.jpg");// 设置默认头像
			try {
				dao.save(user);
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				throw new UserException("注册失败");
			}

			// 发送激活邮件邮件
			//SendMail sendMail = new SendMail();
			//sendMail.send(user);
		}
	}

	/**
	 * 用户激活
	 * 
	 * @param activationCode
	 * @return
	 * @throws UserException
	 */
	public void activateUser(String activationCode) throws UserException {
		User user = (User) dao.find("activationCode", activationCode);
		if (user == null) {
			throw new UserException("无效激活码");
		} else if (user.isStatus()) {
			throw new UserException("用户已激活");
		} else {
			user.setStatus(true);
			dao.update(user);
		}

	}

	/**
	 * 用户登陆
	 * 
	 * @param email
	 * @param password
	 * @return user 用户
	 * @throws UserException
	 */

	public User loginUser(String email, String password) throws UserException {

		User user = (User) dao.find("email", email);

		if (user == null) {
			throw new UserException("账号错误");
		} else if (!password.equals(user.getPassword())) {
			throw new UserException("密码错误");
		} else {

			return user;
		}

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
	 * @throws UserException 
	 */

	public void modify(User user) throws UserException {

		User findUser = (User) dao.find("nickname", user.getNickname());
		if (findUser == null || findUser.getUid().equals(user.getUid())) {
			dao.update(user);
		}else{
			throw new UserException("用户名已存在");
		}

	}

}
