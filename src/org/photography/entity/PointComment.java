package org.photography.entity;

import java.io.Serializable;
import java.util.Date;

public class PointComment implements Serializable{
	private Integer pcId;        //坐标id
	private String comment;        //介绍
	private Date createTime;      //创建日期
	private Integer praise;        //赞
	private User user;
	private Point point;
	
	public Integer getPcId() {
		return pcId;
	}
	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}

}
