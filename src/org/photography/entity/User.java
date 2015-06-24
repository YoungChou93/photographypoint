package org.photography.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 * 
 * @author ZhouYang
 *
 * 2015-06-24
 */
public class User implements Serializable{
	
	private Integer uid;       //id
	private String nickname;  //用户名
	private String email;     //邮箱
	private String password;  //密码
	private Integer  gender;     //性别
	private String brief;     //简介
	private String location;  //地区
	private String head;      //头像
	private Date registerTime;// 注册时间
	private String weibo;     //微博
	private String qqNumber;  //qq
	private boolean status;//状态，true表示已激活，或者未激活
	private String activationCode;//激活码，它是唯一值！即每个用户的激活码是不同的！ 
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	private Set<Point> points=new HashSet<Point>();
	private Set<PointComment> pointComments=new HashSet<PointComment>();
	
	
	public Set<PointComment> getPointComments() {
		return pointComments;
	}
	public void setPointComments(Set<PointComment> pointComments) {
		this.pointComments = pointComments;
	}
	

	public Set<Point> getPoints() {
		return points;
	}
	public void setPoints(Set<Point> points) {
		this.points = points;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
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
	
	

}
