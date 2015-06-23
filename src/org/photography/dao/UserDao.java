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
 * 2015-06-21
 *
 */

public class UserDao implements BaseDao {  
	  
    private Session session=HibernateUtils.openSession();  
   
	public Session getSession() {
		return session;
	}
	
	

	@Override
	public void save(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		Transaction ts = session.beginTransaction();
		session.save(obj); 
		ts.commit();
		session.close();
		
	}

	@Override
	public void updata(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		Transaction ts = session.beginTransaction();
		session.update(obj); 
		ts.commit();
		session.close();
		
	}

	@Override
	public void delete(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		Transaction ts = session.beginTransaction();
		session.delete(obj);
		ts.commit();
		session.close();
		
	}

	@Override
	public Object find(String field,String str) throws HibernateException {
		// TODO Auto-generated method stub
		Transaction ts = session.beginTransaction();
		User user = (User)session.createQuery("from User where "+field+" = '"+str+"'")
                .uniqueResult();
		ts.commit();
		session.close();
    	return user;
	}
	
	

	@Override
	public List<Object> findAll() throws HibernateException {
//		Transaction ts = session.beginTransaction();
//		List<Object> list = session.createQuery("from User")
//				.list();
//
//		ts.commit();
//		session.close();
//		return list;
		return null;
	}


	@Override
	public List<Object> findPart(String field, String str)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
	

}  
	


