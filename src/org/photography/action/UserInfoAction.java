package org.photography.action;

import org.photography.entity.User;

import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块，用于修改用户信息的action
 * 
 * @author zhouyang
 * 
 * 2015-06-30
 *
 */
public class UserInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nickname; // 用户名
	private Integer gender; // 性别
	private String brief; // 简介
	private String location; // 地区
	private String ddlProvince; // 省份
	private String ddlCity; // 城市
	private String weibo; // 微博
	private String qqNumber; // qq

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getDdlProvince() {
		return ddlProvince;
	}

	public void setDdlProvince(String ddlProvince) {
		this.ddlProvince = ddlProvince;
	}

	public String getDdlCity() {
		return ddlCity;
	}

	public void setDdlCity(String ddlCity) {
		this.ddlCity = ddlCity;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	@Override
	public String execute() throws Exception {
		User user = (User)ActionContext.getContext().getSession().get("sessionUser");

		if (user != null) {
			location = ddlProvince + " " + ddlCity;
			user.setBrief(brief);
			user.setGender(gender);
			user.setWeibo(weibo);
			user.setLocation(location);
			user.setQqNumber(qqNumber);
			user.setNickname(nickname);
			

			this.setUserService(new UserService());
			userService.modify(user);

			ActionContext.getContext().getSession().put("sessionUser", user);
		}

		return SUCCESS;
	}
}
