package org.photography.action.point;

import org.photography.entity.Point;

import com.opensymphony.xwork2.ActionSupport;

public class AddPointAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Point point;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	

}
