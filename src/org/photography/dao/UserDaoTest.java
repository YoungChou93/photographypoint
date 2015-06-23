package org.photography.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.photography.entity.User;

public class UserDaoTest {
	
	private UserDao userDao=new UserDao();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFind() {
		String field="email";
		String str="qweqeq";
		
		User user=(User) userDao.find(field, str);
		System.out.print(user.getNickname());
	}

}
