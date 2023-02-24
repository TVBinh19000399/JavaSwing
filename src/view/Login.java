package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

import controller.Validation;
import model.UserModel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField taikhoan_txtfield;
	private JTextField matkhau_txtfield;
	private JLabel error_label;
	private JLabel error_label_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 550, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JFrame signUp = new Signup(this);
		setTitle("Đăng nhập");
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel taikhoan_label = new JLabel("Tài khoản");
		taikhoan_label.setBounds(123, 88, 100, 13);
		contentPane.add(taikhoan_label);

		JLabel matkhau_label = new JLabel("Mật khẩu");
		matkhau_label.setBounds(123, 151, 100, 13);
		contentPane.add(matkhau_label);

		taikhoan_txtfield = new JTextField();
		taikhoan_txtfield.setToolTipText(
				"Tài khoản không được bắt đầu bằng kí tự đặc biệt hay chữ số, độ dài không quá 20 kí tự.");
		taikhoan_txtfield.setBounds(271, 80, 178, 30);
		contentPane.add(taikhoan_txtfield);
		taikhoan_txtfield.setColumns(10);

		matkhau_txtfield = new JTextField();
		matkhau_txtfield.setToolTipText(
				"Mật khẩu không được chứa kí tự đặc biệt, chỉ được chứa kí tự hoặc số, độ dài không quá 20 kí tự.");
		matkhau_txtfield.setColumns(10);
		matkhau_txtfield.setBounds(271, 143, 178, 30);
		contentPane.add(matkhau_txtfield);

		JButton dangki_btn = new JButton("Đăng kí");
		dangki_btn.setBounds(123, 238, 121, 36);
		dangki_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signUp.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(dangki_btn);

		JButton dangnhap_btn = new JButton("Đăng nhập");
		dangnhap_btn.setBounds(294, 238, 121, 36);
		dangnhap_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				error_label.setText(Validation.validateAccountInput(taikhoan_txtfield.getText(), 0));
				error_label_1.setText(Validation.validatePasswordInput(matkhau_txtfield.getText()));

				if (error_label.getText() == null && error_label_1.getText() == null) {
					Hashtable<String, String> conditions = new Hashtable<String, String>();
					conditions.put("name", taikhoan_txtfield.getText());
					conditions.put("password", matkhau_txtfield.getText());
					UserModel userModel = new UserModel();
					if (userModel.isExists(conditions)) {
						System.out.println("Login thành công!!!");
						setVisible(false);
						new Home();
					} else {
						error_label.setText("Thông tin đăng nhập không chính xác!!");
					}
				}
			}
		});
		contentPane.add(dangnhap_btn);

		error_label = new JLabel();
		error_label.setForeground(new Color(255, 0, 0));
		error_label.setBounds(271, 59, 255, 21);
		contentPane.add(error_label);

		error_label_1 = new JLabel();
		error_label_1.setForeground(Color.RED);
		error_label_1.setBounds(271, 122, 255, 21);
		contentPane.add(error_label_1);

	}
}
