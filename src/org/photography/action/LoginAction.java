package org.photography.action;

import org.photography.entity.User;
import org.photography.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;  
	  
    private User user;  
  
    private UserService userManager;  
	
	public UserService getUserManager() {
		return userManager;
	}

	public void setUserManager(UserService userManager) {
		this.userManager = userManager;
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
         this.setUserManager(new UserService());  
          
         if(userManager.loginUser(user.getEmail(), user.getPassword()))
         {
        	return SUCCESS; 
         }
         else {
        	
         	return "fail";	 
        	 
		} 

     } catch (Exception e) {  
         e.printStackTrace();  
         return ERROR;  
     }  
	}
	

}
