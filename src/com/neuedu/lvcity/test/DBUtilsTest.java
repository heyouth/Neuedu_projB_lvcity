package com.neuedu.lvcity.test;

import java.sql.Connection;

import org.junit.Test;

import com.neuedu.lvcity.common.DBUtils;

public class DBUtilsTest {

	@Test
	public void testGetConnection() {
		Connection conn = DBUtils.getConnection();
		System.out.println("TestPoint1");
		DBUtils.closeConnection(conn);
		System.out.println("TestPoint");
	}

//	@Test
//	public void testBeginTransaction() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCommit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRollback() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCloseConnection() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCloseStatement() {
//		fail("Not yet implemented");
//	}

}
