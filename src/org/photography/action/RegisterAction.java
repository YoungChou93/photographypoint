package org.photography.action;

import org.photography.entity.User;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
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
	 * 退出
	 * 
	 * @return
	 * @throws Exception
	 */

	public String exit() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}


}
