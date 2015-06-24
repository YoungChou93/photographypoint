package org.photography.dao;

import java.util.List;

import org.hibernate.HibernateException;


public interface BaseDao {
	
	
	/**
	 * 	
	 * ����һ������
	 * 
	 * @param obj ����
	 * @throws HibernateException
	 */
	 public void save(Object obj) throws HibernateException;
	 
	 /**
	  * ����һ������
	  * 
	  * @param obj
	  * @throws HibernateException
	  */
	 
	 public void update(Object obj) throws HibernateException;
	 
	 /**
	  * ɾ��һ������
	  * @param obj
	  * @throws HibernateException
	  */
	 public void delete(Object obj) throws HibernateException;
	 
	 /**
	  * ͨ��ĳһ�ֶε����ݲ���ĳ������
	  * 
	  * @param field  �ֶ�
	  * @param str    ����
	  * @return       ����
	  * @throws HibernateException
	  */
	 
	 public Object find(String field,String str) throws HibernateException;
	 
	 
	 /**
	  * 
	  * @param field �ֶ�
	  * @param str   ƥ�������
	  * @return      �����б�
	  * @throws HibernateException
	  */
	 public List<Object> findPart(String field,String str) throws HibernateException;
	 
	 public List<Object> findAll() throws HibernateException;
	 

}
