package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	private static Connection con;
	private static String dbName = "project2nf";
	private static String userName = "root";
	private static String password = "";

	public static Connection getConnection() {
		if (con == null) {
			// trong trường hợp mới kết nối lần đầu cần kiểm tra db đã tồn tại hay chưa để
			// tạo
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", userName, password);
				Statement stmt = con.createStatement();
				String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
				stmt.executeUpdate(sql);

				// trong trường hợp DB mới tạo chưa có bảng thì phải tạo nó
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
				stmt = con.createStatement();
				String createBookTable = "CREATE TABLE  if not exists `book`("
						+ "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," + "`name` varchar(250) NOT NULL,"
						+ "`number_of_page` int(1) NOT NULL," + "`price` int(1) NOT NULL" + ");";
				stmt.executeUpdate(createBookTable);
				String createUserTable = "CREATE TABLE  if not exists `user`("
						+ "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," + "`name` varchar(250) NOT NULL,"
						+ "`password` varchar(250) NOT NULL" + ");";
				stmt.executeUpdate(createUserTable);
				System.out.println("New connection is created!!!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("Connection is ok!");
		return con;
	}

}
