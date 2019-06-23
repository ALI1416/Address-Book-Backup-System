package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	public static final String driver = "com.mysql.jdbc.Driver";
	// 数据库驱动
	public static final String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8";
	// 连接数据库的URL地址，使用shop库，字符集为utf
	public static final String username = "root";
	// 数据库用户名
	public static final String password = "root";
	// 数据库密码

	// 连接对象
	public static Connection conn = null;

	// 静态代码块负责加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 单例模式 返回数据库连接对象
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			// 连接数据库
			return conn;
		}
		return conn;
	}

	// 测试
	/*
	 * public static void main(String[] args) { try { Connection conn =
	 * DBHelper.getConnection(); if(conn!=null) { System.out.println("数据库连接正常！");
	 * }else { System.out.println("数据库连接异常！"); } }catch(Exception e) {
	 * e.printStackTrace(); } }
	 */
}
