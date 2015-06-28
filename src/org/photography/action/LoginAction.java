package org.photography.action;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.photography.entity.User;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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

	@Override
	public String execute() throws Exception {

		try {
			this.setUserService(new UserService());
			User loginUser = userService.loginUser(user.getEmail(),
					user.getPassword());
			if (loginUser != null) {
				if (loginUser.isStatus()) {
					ActionContext.getContext().getSession()
							.put("sessionUser", loginUser);
					String loginname = user.getEmail();
					loginname = URLEncoder.encode(loginname, "utf-8");
					Cookie cookie = new Cookie("loginname", loginname);
					cookie.setMaxAge(60 * 60 * 24 * 10);// 保存10天
					ServletActionContext.getResponse().addCookie(cookie);
				} else {
					ServletActionContext.getRequest().setAttribute("msg","您还没有激活");
					ServletActionContext.getRequest().setAttribute("user", user);
				}
				return SUCCESS;
			} else {
				ServletActionContext.getRequest().setAttribute("msg","用户名或密码错误！");
				ServletActionContext.getRequest().setAttribute("user", user);
				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
