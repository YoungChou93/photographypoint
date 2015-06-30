package org.photography.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.photography.entity.User;
import org.photography.utils.HibernateUtils;

/**
 * 用户模块
 * 
 * 数据持久层
 * 
 * @author ZhouYang
 * 
 *         2015-06-21
 *
 */

public class UserDao implements BaseDao {

	

	@Override
	public void save(Object obj) throws HibernateException {
		Session session = HibernateUtils.openSession();
		try {
			Transaction ts = session.beginTransaction();
			session.save(obj);
			ts.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void update(Object obj) throws HibernateException {
		
		Session session = HibernateUtils.openSession();
		try {
			Transaction ts = session.beginTransaction();
			session.update(obj);
			ts.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(Object obj) throws HibernateException {
		
		Session session = HibernateUtils.openSession();
		try {
			Transaction ts = session.beginTransaction();
			session.delete(obj);
			ts.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Object find(String field, String str) throws HibernateException {
		
		Session session = HibernateUtils.openSession();
		User user = null;
		try {

			Transaction ts = session.beginTransaction();
			user = (User) session.createQuery(
					"from User where " + field + " = '" + str + "'")
					.uniqueResult();
			ts.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public List<Object> findAll() throws HibernateException {
		// Transaction ts = session.beginTransaction();
		// List<Object> list = session.createQuery("from User")
		// .list();
		//
		// ts.commit();
		// session.close();
		// return list;
		return null;
	}

	@Override
	public List<Object> findPart(String field, String str)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
