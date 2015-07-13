package org.photography.service;


import java.util.Date;
import java.util.List;

import org.photography.dao.PointDao;
import org.photography.entity.Point;

/**
 * 摄影点模块  业务层
 * 
 * @author zhouyang
 *
 * 2015-7-13
 */
public class PointService {

	private PointDao pointDao;
	
	public PointService(){
		
		pointDao=new PointDao();
	}
	/**
	 * 保存摄影点
	 * @param point
	 */
	public void savePoint(Point point){
		Date date = new Date();
		point.setCreateTime(date);
		point.setPraise(0);
		pointDao.save(point);
	}
	
	/**
	 * 通过标签查找摄影点
	 * @param searchValue
	 * @return
	 */
	public List<Point> findByLabel(String searchValue){
		
		return pointDao.findPart("label", searchValue);
		
	}
	
	/**
	 * 通过城市查找摄影点
	 * @param searchValue
	 * @return
	 */
	public List<Point> findByCity(String searchValue){
		
		
		return pointDao.findPart("city", searchValue);
		
	}
	
}
