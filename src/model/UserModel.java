package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import model.entities.User;

public class UserModel extends BaseModel {

	public UserModel() {
		super();
		this.setTable("user");
	}

	ArrayList<User> read(Hashtable whereCondition) {

		ArrayList<User> userlist = new ArrayList<User>();
		String sql = "SELECT * from " + this.getTable() + " ";

		if (whereCondition != null) {
			Set<String> keys = whereCondition.keySet();
			if (keys.size() != 0) {
				sql = sql + " where ";
				for (String key : keys) {
					sql = sql + key + "=" + "'" + whereCondition.get(key) + "'" + " and ";
				}
				sql = sql.substring(0, sql.length() - 5);
			}
		}

		Statement stmt;
		try {
			stmt = this.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String user_name = rs.getString("name");
				String password = rs.getString("password");
				String id = rs.getString("id");
				userlist.add(new User(id, user_name, password));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userlist;
	}

	public boolean create(User newUser) {
		String sql = "INSERT INTO user VALUES (0, '" + newUser.getName() + "', '" + newUser.getPassword() + "' )";

		Statement stmt;
		try {
			stmt = this.getCon().createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	boolean delete(Hashtable whereCondition) {

		String sql = "DELETE from " + this.getTable() + " where ";
		if (whereCondition != null) {
			Set<String> keys = whereCondition.keySet();
			if (keys.size() != 0) {
				for (String key : keys) {
					sql = sql + key + "=" + "'" + whereCondition.get(key) + "'" + " and ";
				}
				sql = sql.substring(0, sql.length() - 5);
			}
		}

		Statement stmt;
		try {
			stmt = this.getCon().createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	void update() {

	}

}
