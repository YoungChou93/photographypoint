package org.photography.action;

import org.photography.entity.User;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 与用户模块相关的action
 * 
 * @author ZhouYang
 * 
 *         2015-06-20
 *
 */

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;

	private UserService userService;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {

		return super.execute();
	}

	/**
	 * 注册
	 * 
	 * @return
	 * @throws Exception
	 */

	public String register() throws Exception {

		try {
			this.setUserService(new UserService());
			userService.regUser(user);
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	/**
	 * 激活
	 * 
	 * @return
	 * @throws Exception
	 */

//	public String activate() throws Exception {
//		this.setUserService(new UserService());
//		if (userService.activateUser(user)) {
//			return SUCCESS;
//		} else {
//			return ERROR;
//		}
//	}

	/**
	 * 登陆
	 * 
	 * @return
	 * @throws Exception
	 */

//	public String login() throws Exception {
//		try {
//			this.setUserService(new UserService());
//
//			if (userService.loginUser(user.getEmail(), user.getPassword())) {
//				return SUCCESS;
//			} else {
//
//				return "fail";
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ERROR;
//		}
//	}

	/**
	 * 退出
	 * 
	 * @return
	 * @throws Exception
	 */

	public String exit() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	/**
	 * 更新
	 * 
	 * @return
	 * @throws Exception
	 */

	public String modify() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

}
