package org.photography.utils.mail;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import org.photography.entity.User;


public class SendMail {
	
	public void send(User user){
		/*
		 * 3. 发邮件
		 */
		/*
		 * 把配置文件内容加载到prop中
		 */
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		/*
		 * 登录邮件服务器，得到session
		 */
		String host = prop.getProperty("host");//服务器主机名
		String name = prop.getProperty("username");//登录名
		String pass = prop.getProperty("password");//登录密码
		Session session = MailUtils.createSession(host, name, pass);
		
		/*
		 * 创建Mail对象
		 */
		String from = prop.getProperty("from");
		String to = user.getEmail();
		String subject = prop.getProperty("subject");
		// MessageForm.format方法会把第一个参数中的{0},使用第二个参数来替换。
		// 例如MessageFormat.format("你好{0}, 你{1}!", "张三", "去死吧"); 返回“你好张三，你去死吧！”
		String content = MessageFormat.format(prop.getProperty("content"), user.getActivationCode());
		Mail mail = new Mail(from, to, subject, content);
		/*
		 * 发送邮件
		 */
		try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
