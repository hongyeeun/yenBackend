package com.yen.member.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	// JDBCTemplate 에서 conn객체 생성
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME ="yenJDBC";
	private static final String PASSWORD ="yenJDBC";
	
	private static Connection conn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn==null || conn.isClosed()) {
			// 싱글톤이용해서 만들기
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		return conn;
	}
}

