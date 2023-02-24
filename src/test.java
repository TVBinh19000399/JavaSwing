import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {

		String chuoiInput = "uuylul";
		System.out.println(validateInput(chuoiInput));

	}

	static String validateInput(String inputString) {
		if (inputString.trim().length()<6) {
			return "Không được ngắn hơn 6 kí tự!";
		}
		if (inputString.trim().length()==0) {
			return "Không được điền kí tự trống!";
		}
		if (inputString.trim().length()>20) {
			return "Không được dài quá 20 kí tự!";
		}
		
		Pattern weird_character = Pattern.compile(".*[^0-9a-zA-Z_].*");
		Matcher matcher0 = weird_character.matcher(inputString);
		boolean matchFound0 = matcher0.matches();
		if (matchFound0) {
			return "Không được chứa kí tự đặc biệt!";
		}
		
		
		Pattern number_ahead = Pattern.compile("[0-9][a-zA-Z]+");
		Matcher matcher1 = number_ahead.matcher(inputString);
		boolean matchFound1 = matcher1.matches();
		if (matchFound1) {
			return "Không được bắt đầu bằng số!";
		}
		
		//Thêm bước kiểm tra inputString đã tồn tại trong DB chưa
		
		
		return "OK!";
	}

}
