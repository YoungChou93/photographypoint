package org.photography.action;

import org.apache.struts2.ServletActionContext;
import org.photography.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块
 * 
 * 用户退出登陆
 * 
 * @author zhouyang
 *
 */

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String logout;

	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}

	@Override
	public String execute() {

		User user = (User) ActionContext.getContext().getSession()
				.get("sessionUser");
		if (user != null && logout.equals("logout")) {
			ActionContext.getContext().getSession().clear();
		} else {
			ServletActionContext.getRequest().setAttribute("errorMsg", "未登录");
			return ERROR;
		}

		return SUCCESS;
	}

}
