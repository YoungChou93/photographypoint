package org.photography.action;

import org.photography.entity.User;


import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;  
	  
    private User user;  
  
    private UserService userManager;  
  
    public User getUser() {  
        return user;  
    }  
  
    public void setUser(User user) {  
        this.user = user;  
    }  
  
    public UserService getUserManager() {  
        return userManager;  
    }  
  
    public void setUserManager(UserService userManager) {  
        this.userManager = userManager;  
    }  
  
    public String execute() {  
        try {  
            this.setUserManager(new UserService());  
            userManager.regUser(user);  
            return SUCCESS;  
  
        } catch (Exception e) {  
            e.printStackTrace();  
            return ERROR;  
        }  
    }  

}
