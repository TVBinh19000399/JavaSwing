

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCrud {

	static final String QUERY = "SELECT * from book";

	public static void main(String[] args) {
		// connect to database, ok
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc?useSSL=false", "root", "");
			System.out.println("Connection is ok!!!");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi ket noi !!!");
		}

		// Read - select record, ok
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc?useSSL=false", "root",
				""); Statement stmt = c.createStatement(); 
				ResultSet rs = stmt.executeQuery(QUERY);) {
//			String createBookTable = "CREATE TABLE  if not exists `book`("
//			+ "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
//			+ "`name` varchar(250) NOT NULL,"
//			+ "`number_of_page` int(1) NOT NULL,"
//			+ "`price` int(1) NOT NULL"
//			+ ");";
//	stmt.executeUpdate(createBookTable);
			while (rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.println(", Name: " + rs.getString("name"));
			}
			System.out.println("read data is ok!!!");
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Loi khong read duoc!");
		}

		// Create - insert record, ok
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc?useSSL=false", "root",
				""); Statement stmt = c.createStatement();) {
			String createBookTable = "CREATE TABLE  if not exists `book`("
					+ "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
					+ "`name` varchar(250) NOT NULL,"
					+ "`number_of_page` int(1) NOT NULL,"
					+ "`price` int(1) NOT NULL"
					+ ");";
			stmt.executeUpdate(createBookTable);
			String sql = "INSERT INTO book VALUES (0, 'new book',200, 25000 )";
			stmt.executeUpdate(sql);
			System.out.println("insert ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bi loi khi insert!!!");
		}

		// Update - update record, ok
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc?useSSL=false", "root",
				""); Statement stmt = c.createStatement();) {

			String update = "UPDATE book " + "SET number_of_page = 122 WHERE id =2";
			stmt.executeUpdate(update);

			System.out.println("Update is ok!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bi loi update!!!");
		}

		// Delete - remove record, ok
		try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javajdbc?useSSL=false", "root",
				""); Statement stmt = c.createStatement();) {

			String delete = "delete from book where id= 7  ";
			stmt.executeUpdate(delete);

			System.out.println("delete is ok!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bi loi delete!!!");
		}
		
		
		// close connection
		try {
			con.close();
			System.out.println("Connection is closed!!!");
		} catch (SQLException e) {
			System.out.println("Bi loi khi close connection!!!");
		}
	}

}
