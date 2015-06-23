package org.photography.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * �û�ģ��
 * �û�ʵ��
 * @author ZhouYang
 *
 */
public class User implements Serializable{
	
	private Integer uid;       //�û�id
	private String nickname;  //�ǳ� 
	private String email;     //���䡢��½��
	private String password;  //����
	private Integer  gender;     //�Ա�
	private String brief;     //���
	private String location;  //����
	private String head;      //ͷ��url
	private Date registerTime;// ע��ʱ��
	private String weibo;     //΢��
	private String qqNumber;  //QQ��
	
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
