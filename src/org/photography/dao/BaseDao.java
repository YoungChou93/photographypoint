package org.photography.dao;

import java.util.List;

import org.hibernate.HibernateException;


public interface BaseDao<T> {
	
	
	/**
	 * 	
	 *  保存对象
	 * 
	 * @param obj 
	 * @throws HibernateException
	 */
	 public void save(T obj) throws HibernateException;
	 
	 /**
	  * 更新对象
	  * 
	  * @param obj
	  * @throws HibernateException
	  */
	 
	 public void update(T obj) throws HibernateException;
	 
	 /**
	  * 删除对象
	  * @param obj
	  * @throws HibernateException
	  */
	 public void delete(T obj) throws HibernateException;
	 
	 /**
	  * ͨ通过某一字段查找
	  * 
	  * @param field  字段
	  * @param str    数据
	  * @return       对象
	  * @throws HibernateException
	  */
	 
	 public T find(String field,String str) throws HibernateException;
	 
	 
	 /**
	  * 
	  * @param field 
	  * @param str   
	  * @return      
	  * @throws HibernateException
	  */
	 public List<T> findPart(String field,String str) throws HibernateException;
	 
	 public List<T> findAll() throws HibernateException;
	 

}
