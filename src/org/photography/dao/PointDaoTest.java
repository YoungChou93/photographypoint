package org.photography.dao;



import org.junit.Before;
import org.junit.Test;

public class PointDaoTest {
	
	private PointDao pointDao=new PointDao();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		pointDao.findPart("city", "武汉");
	}

}
