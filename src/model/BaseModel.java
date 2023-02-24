package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Set;
import common.DatabaseConnector;

public abstract class BaseModel {

	private Connection con;
	private String table;

	public BaseModel() {
		super();
		this.con = DatabaseConnector.getConnection();
	}

	// check một phần tử có trong bảng
	public  Boolean isExists(Hashtable whereCondition) {
		String sql = "SELECT * from " + this.table + " ";

		if (whereCondition != null) {
			Set<String> keys = whereCondition.keySet();
			if (keys.size() != 0) {
				sql = sql + " where ";
				for (String key : keys) {
					sql = sql + key + "=" + "'"+whereCondition.get(key) +"'"+ " and ";
				}
				sql = sql.substring(0, sql.length() - 5);
			}
		}
		Statement stmt;
		int count = 0;
		try {
			stmt = this.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count++;
			}

		} catch (SQLException e) {
		}

		return count > 0;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
