package org.photography.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import org.photography.utils.VerifyCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 提供验证码的Action
 * 
 * @author ZhouYang
 * 
 * 2015-6-20
 *
 */

public class VerifyCodeAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;


	private ByteArrayInputStream imageStream;
	

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}


	@Override
	public String execute() throws Exception {
		//获取验证码图片，并转化为图片流
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		imageStream=vc.convertImageToStream(image);
		
		//将验证码放入session
		ActionContext context = ActionContext.getContext();
		context.getSession().put("session_vcode", vc.getText());
		
		return SUCCESS;
	}

}
