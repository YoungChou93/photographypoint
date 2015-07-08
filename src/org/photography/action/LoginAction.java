package org.photography.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.photography.entity.User;
import org.photography.exception.UserException;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块
 * 
 * 登陆方法
 * 
 * @author zhouyang
 * 
 *         2015-06-30
 *
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 用户登陆
	 * 
	 */

	@Override
	public String execute() {

		this.setUserService(new UserService());
		User loginUser;
		try {
			loginUser = userService.loginUser(user.getEmail(),
					user.getPassword());
			ActionContext.getContext().getSession()
					.put("sessionUser", loginUser);
			String loginname = user.getEmail();
			loginname = URLEncoder.encode(loginname, "utf-8");
			Cookie cookie = new Cookie("loginname", loginname);
			cookie.setMaxAge(60 * 60 * 24 * 10);// 保存10天
			ServletActionContext.getResponse().addCookie(cookie);
			
		} catch (UserException e) {
			
			ServletActionContext.getRequest().setAttribute("errorMsg",
					e.getMessage());
			ServletActionContext.getRequest().setAttribute("user", user);
			return ERROR;
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;

	}

}
