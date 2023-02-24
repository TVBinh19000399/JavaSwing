package controller;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.UserModel;

public class Validation {

	public static String validateAccountInput(String inputString, int form) {
		// 0 la form login, 1 la form dang ki
		if (inputString.trim().length() < 6) {
			return "Không được ngắn hơn 6 kí tự!";
		}
		if (inputString.trim().length() == 0) {
			return "Không được điền kí tự trống!";
		}
		if (inputString.trim().length() > 30) {
			return "Không được dài quá 30 kí tự!";
		}

		Pattern weird_character = Pattern.compile(".*[^0-9a-zA-Z_@\\.].*");
		Matcher matcher0 = weird_character.matcher(inputString);
		boolean matchFound0 = matcher0.matches();
		if (matchFound0) {
			return "Không được chứa kí tự đặc biệt!";
		}

		Pattern email_form = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?``{|}~^.-]+@[a-zA-Z0-9.-]+$");
		Matcher matcher2 = email_form.matcher(inputString);
		boolean matchFound2 = matcher2.matches();
		if (!matchFound2) {
			return "Viết đúng định dạng email!";
		}

		Pattern number_ahead = Pattern.compile("[0-9].+");
		Matcher matcher1 = number_ahead.matcher(inputString);
		boolean matchFound1 = matcher1.matches();
		if (matchFound1) {
			return "Không được bắt đầu bằng số!";
		}

		Hashtable<String, String> conditions = new Hashtable<String, String>();
		conditions.put("name", inputString);
		UserModel userModel = new UserModel();
		if (!userModel.isExists(conditions) && form == 0) {
			return "Tài khoản không tồn tại!";
		}
		if (userModel.isExists(conditions) && form == 1) {
			return "Tài khoản đã tồn tại!";
		}

		return null;
	}

	public static String validatePasswordInput(String inputString) {
		if (inputString.trim().length() < 6) {
			return "Không được ngắn hơn 6 kí tự!";
		}
		if (inputString.trim().length() == 0) {
			return "Không được điền kí tự trống!";
		}
		if (inputString.trim().length() > 20) {
			return "Không được dài quá 20 kí tự!";
		}

		Pattern weird_character = Pattern.compile(".*[^0-9a-zA-Z_].*");
		Matcher matcher0 = weird_character.matcher(inputString);
		boolean matchFound0 = matcher0.matches();
		if (matchFound0) {
			return "Mật khẩu không được chứa kí tự đặc biệt!";
		}

		return null;
	}
}
