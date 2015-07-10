package org.photography.action;

import org.apache.struts2.ServletActionContext;
import org.photography.entity.User;
import org.photography.exception.UserException;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private User user;

	private UserService userService;
	
	private String verifyCode;

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

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
	 */

	public String register() {
		
		if (ActionContext.getContext().getSession().get("session_vcode")
				.equals(verifyCode)) {

			this.setUserService(new UserService());
			try {
				userService.regUser(user);
			} catch (UserException e) {
				ServletActionContext.getRequest().setAttribute("errorMsg",
						e.getMessage());
				return INPUT;
			}
			return SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg",
					"验证码错误");
			return INPUT;
		}
	}

}
