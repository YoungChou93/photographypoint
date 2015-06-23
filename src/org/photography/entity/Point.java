package org.photography.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Point implements Serializable{
	private Integer pointId;        //����id
	private String title;          //����
	private String content;        //����
	private String longitude;      //����
	private String latitude;       //γ��
	private Date createTime;      //��������
	private String city;           //���ڳ���   
	private String label;          //��ǩ
	private String largePhotoUrl;  //��ͼ��ַ 
	private String smallPhotoUrl;  //Сͼ��ַ 
	private Integer praise;        //��
	private User user;             //�û�
	
	private Set<PointComment> pointComments=new HashSet<PointComment>();
	
	public Set<PointComment> getPointComments() {
		return pointComments;
	}
	public void setPointComments(Set<PointComment> pointComments) {
		this.pointComments = pointComments;
	}
	public Integer getPointId() {
		return pointId;
	}
	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLargePhotoUrl() {
		return largePhotoUrl;
	}
	public void setLargePhotoUrl(String largePhotoUrl) {
		this.largePhotoUrl = largePhotoUrl;
	}
	public String getSmallPhotoUrl() {
		return smallPhotoUrl;
	}
	public void setSmallPhotoUrl(String smallPhotoUrl) {
		this.smallPhotoUrl = smallPhotoUrl;
	}
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
