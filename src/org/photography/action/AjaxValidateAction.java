package org.photography.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.photography.entity.User;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 用于异步验证的action
 * 
 * @author zhouyang
 * 
 * 2015-06-20
 *
 */

public class AjaxValidateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 验证码
	 */
	private String verifyCode;
	
	/**
	 * 用户名
	 */

	private String nickname;
	
	/**
	 * 邮箱
	 */

	private String email;
	
	/**
	 * 
	 */
	private UserService userService;  

	private InputStream inputStream;
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public InputStream getInputStream() {
		return inputStream;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	
	
	
	public String ajaxValidateEmail() throws Exception {

		userService=new UserService();   
	     
        if(userService.findEmail(email)){
			inputStream = new ByteArrayInputStream("fail".getBytes("utf-8"));
		} else {
			inputStream = new ByteArrayInputStream("success".getBytes("utf-8"));
		}

		return SUCCESS;
	}
	
	public String ajaxValidateNickname() throws Exception {

		userService=new UserService();   
	     
        if(userService.findNickname(nickname)) {
			inputStream = new ByteArrayInputStream("fail".getBytes("utf-8"));
		} else {
			inputStream = new ByteArrayInputStream("success".getBytes("utf-8"));
		}

		return SUCCESS;
	}
	
	/**
	 * 验证验证码
	 * @return
	 * @throws Exception
	 */

	public String ajaxValidateVerifyCode() throws Exception {

		ActionContext context = ActionContext.getContext();
		if (context.getSession().get("session_vcode").equals(verifyCode)) {
			inputStream = new ByteArrayInputStream("success".getBytes("utf-8"));
		} else {
			inputStream = new ByteArrayInputStream("fail".getBytes("utf-8"));
		}

		return SUCCESS;
	}
	

}
