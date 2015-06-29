package org.photography.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {

	private static ServiceRegistry serviceRegistry = null;
	private static Configuration cfg = null;
	private static SessionFactory sessionFactory = null;

	static {

		try {
			cfg = new Configuration()
			       .configure();
			serviceRegistry = new StandardServiceRegistryBuilder()//
			       .applySettings(cfg.getProperties())//
			       .build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.toString());
		}
	}

	/**
	 * ��ȡSessionFactory
	 * 
	 * @return SessionFactory
	 */

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * ��SessionFactory��ȡSession
	 * 
	 * @return Session
	 */

	public static Session openSession() {
		return sessionFactory.openSession();
	}

}
