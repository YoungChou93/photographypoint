package org.photography.action.point;

import java.util.List;

import org.photography.entity.Point;
import org.photography.service.PointService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 摄影点模块
 * 
 * 查询摄影点
 * 
 * @author zhouyang
 *
 *         2015-7-13
 */

public class SearchPointAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SUCCESSLIST = "successlist";

	private static final String SUCCESSMAP = "successmap";

	private List<Point> points;

	private String city;

	private String label;

	private String view;

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
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

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public String execute() throws Exception {
		PointService pointService = new PointService();
		points = pointService.findByCity("武汉");

		if (view == null) {
			return SUCCESSMAP;
		} else if (view.equals("list")) {
			return SUCCESSLIST;
		} else {
			return SUCCESSMAP;
		}

	}

}
