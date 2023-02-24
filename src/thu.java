

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.*;
import common.DatabaseConnector;
import model.UserModel;
import model.entities.User;

public class thu {

	public static void main(String[] args) {
		UserModel userModel = new UserModel();

		Hashtable<String, String> whereCondition = new Hashtable<String, String>();
		whereCondition.put("name", "newacc@gmail.com");

		// test lấy dữ liệu từ bảng user, ok
//		ArrayList<User> userlist = userModel.read(null);
//		System.out.println("Begin testing:");
//		System.out.println("Kich thuoc users: " + userlist.size());
//		for (int i = 0; i < userlist.size(); i++) {
//			System.out.println(userlist.get(i));
//		}

		// test delete dữ liệu user, ok
//		System.out.println(userModel.delete(whereCondition));
		
		
		//test thêm dữ liệu, ok
		boolean isaddok = userModel.create(new User("0","newacc@gmail.com","newpassword"));
//		System.out.println("Tinh trang ham create: "+isaddok);
		
		//test update dữ liệu

	}

}
