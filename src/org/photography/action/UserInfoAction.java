package org.photography.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;
import org.photography.entity.User;
import org.photography.service.UserService;
import org.photography.utils.CommonUtils;

import sun.misc.BASE64Decoder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块
 * 
 * 包括
 *   修改基本信息
 *   修改密码
 *   修改头像
 * 
 * @author zhouyang
 * 
 *    2015-06-30
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

	private String oldpassword;// 原密码
	private String newpassword;// 新密码

	private File headpicture;// 头像图片
	private String contentType;// 文件类型
	private String fileName;// 文件名
	private String savePath;

	private String headpictureString;

	private UserService userService;

	public String getHeadpictureString() {
		return headpictureString;
	}

	public void setHeadpictureString(String headpictureString) {
		this.headpictureString = headpictureString;
	}

	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	public File getHeadpicture() {
		return headpicture;
	}

	public void setHeadpicture(File headpicture) {
		this.headpicture = headpicture;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

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

	/**
	 * 修改基本信息
	 */
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession()
				.get("sessionUser");

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

	/**
	 * 修改密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifyPassword() throws Exception {
		User user = (User) ActionContext.getContext().getSession()
				.get("sessionUser");
		if (user != null && user.getPassword().equals(oldpassword)) {

			user.setPassword(newpassword);
			this.setUserService(new UserService());
			userService.modify(user);

			ActionContext.getContext().getSession().put("sessionUser", user);
		}else{
			
			
			
			return ERROR;
		}
		
		return SUCCESS;
	}

	/**
	 * 校验修改密码方法
	 */
	public void validateModifyPassword() {
		if (oldpassword != null
				&& !Pattern.matches("\\w{6,16}", oldpassword.trim())) {
			addFieldError(oldpassword, "密码输入不合法,6~16");
		}
		if (newpassword != null
				&& !Pattern.matches("\\w{6,16}", newpassword.trim())) {
			addFieldError(newpassword, "密码输入不合法,6~16");
		}
	}

	public String modifyHead() throws Exception {
		User user = (User) ActionContext.getContext().getSession()
				.get("sessionUser");
		if (user != null) {
			FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
					+ user.getUid() + CommonUtils.uuid() + ".jpg");
			FileInputStream fis = new FileInputStream(getHeadpicture());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		}
		return SUCCESS;

	}
    /**
     * 修改头像
     * @return
     * @throws Exception
     */
	public String modifyHeadPicture() throws Exception {

		User user = (User) ActionContext.getContext().getSession()
				.get("sessionUser");
		if (user != null) {
			if (headpictureString == null) // 图像数据为空
				return ERROR;
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				// Base64解码
				String imageString = headpictureString.substring(22);

				byte[] b = decoder.decodeBuffer(imageString);
				// 生成jpeg图片
				String imageName = user.getUid() + CommonUtils.uuid() + ".jpg";
				String imgFilePath = getSavePath() + "\\" + imageName;// 新生成的图片

				OutputStream out = new FileOutputStream(imgFilePath);
				out.write(b);
				out.flush();
				out.close();

				user.setHead("/file/headpicture/" + imageName);
				this.setUserService(new UserService());
				userService.modify(user);
				
				ActionContext.getContext().getSession().put("sessionUser", user);
				return SUCCESS;
			} catch (Exception e) {
				return ERROR;
			}
		} else {
			return ERROR;
		}
	}
}
