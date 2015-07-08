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

public class UserDao implements BaseDao<User> {

	@Override
	public void save(User obj) {
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
	public void update(User obj){

		Session session = HibernateUtils.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.update(obj);
			ts.commit();
		} catch (RuntimeException  e) {
			ts.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(User obj){

		Session session = HibernateUtils.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.delete(obj);
			ts.commit();
		} catch (RuntimeException  e) {
			ts.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public User find(String field, String str) {

		Session session = HibernateUtils.openSession();
		User user = null;
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			user = (User) session.createQuery(
					"from User where " + field + " = '" + str + "'")
					.uniqueResult();
			ts.commit();
		} catch (RuntimeException  e) {
			ts.rollback();
			throw e;
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public List<User> findAll() throws HibernateException {
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
	public List<User> findPart(String field, String str)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
