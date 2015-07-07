package org.photography.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块
 * 
 * 用户激活方法
 * 
 * @author ZhouYang
 * 
 * 2015-6-24
 *
 */

public class ActivateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 激活码
	 */
	private String activationCode;
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getActivateCode() {
		return activationCode;
	}

	public void setActivateCode(String activateCode) {
		this.activationCode = activateCode;
	}

	
	public String activate() throws Exception {
		
		this.setUserService(new UserService());
		HttpServletRequest request = ServletActionContext.getRequest();
        String activationCode = request.getParameter("activationCode");
		if (userService.activateUser(activationCode)) {
			
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	

}
