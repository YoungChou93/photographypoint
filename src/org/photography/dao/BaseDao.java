package org.photography.dao;

import java.util.List;

import org.hibernate.HibernateException;


public interface BaseDao<T> {
	
	
	/**
	 * 	
	 *  保存对象
	 * 
	 * @param obj 
	 * 
	 */
	 public void save(T obj);
	 
	 /**
	  * 更新对象
	  * 
	  * @param obj
	  *
	  */
	 
	 public void update(T obj);
	 
	 /**
	  * 删除对象
	  * @param obj
	  * 
	  */
	 public void delete(T obj);
	 
	 /**
	  * ͨ通过某一字段查找对象
	  * 
	  * @param field  字段
	  * @param str    数据
	  * @return       对象
	  * 
	  */
	 
	 public T find(String field,String str);
	 
	 
	 /**
	  * 通过某一字段查找一组对象
	  * 
	  * @param field 字段
	  * @param str   数据
	  * @return      对象列表
	  * 
	  */
	 public List<T> findPart(String field,String str);
	 
	 public List<T> findAll();
	 

}
