package org.photography.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.photography.entity.Point;
import org.photography.utils.HibernateUtils;

/**
 * 摄影点模块 、持久层
 * 
 * @author zhouyang
 * 
 * 2015-7-13
 *
 */
public class PointDao implements BaseDao<Point> {

	@Override
	public void save(Point obj) {

		Session session = HibernateUtils.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(obj);
			ts.commit();
		} catch (RuntimeException e) {
			ts.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void update(Point obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Point obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Point find(String field, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point> findPart(String field, String str) {
		Session session = HibernateUtils.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			List<Point> points = session.createQuery(
					"from Point where " + field + " = '" + str + "'")
					.list();
			ts.commit();
			return points;
		} catch (RuntimeException e) {
			ts.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Point> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
