package org.photography.dao;

import java.util.List;

import org.hibernate.HibernateException;


public interface BaseDao {
	
	
	/**
	 * 	
	 * 保存一个对象
	 * 
	 * @param obj 对象
	 * @throws HibernateException
	 */
	 public void save(Object obj) throws HibernateException;
	 
	 /**
	  * 更新一个对象
	  * 
	  * @param obj
	  * @throws HibernateException
	  */
	 
	 public void updata(Object obj) throws HibernateException;
	 
	 /**
	  * 删除一个对象
	  * @param obj
	  * @throws HibernateException
	  */
	 public void delete(Object obj) throws HibernateException;
	 
	 /**
	  * 通过某一字段的内容查找某个对象
	  * 
	  * @param field  字段
	  * @param str    内容
	  * @return       对象
	  * @throws HibernateException
	  */
	 
	 public Object find(String field,String str) throws HibernateException;
	 
	 
	 /**
	  * 
	  * @param field 字段
	  * @param str   匹配的内容
	  * @return      对象列表
	  * @throws HibernateException
	  */
	 public List<Object> findPart(String field,String str) throws HibernateException;
	 
	 public List<Object> findAll() throws HibernateException;
	 

}
