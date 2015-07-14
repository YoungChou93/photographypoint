package org.photography.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImageUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ImageUtil imageUtil=new ImageUtil();
		try {
			imageUtil.saveImageAsJpg("D:/1234.jpg","D:/sfsdfdf.jpg",600,400);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
