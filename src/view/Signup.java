package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Validation;
import model.UserModel;
import model.entities.User;

import javax.swing.JButton;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField taotaikhoan_txtfield;
	private JTextField taomatkhau_txtfield;
	private JLabel nhaplaimatkhau_label;
	private JTextField nhaplaimatkhau_txtfield;
	private JFrame previousFrame;
	private JLabel error_label;
	private JLabel error_label_1;
	private JLabel error_label_2;

	public Signup(JFrame previousFrame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 550, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.previousFrame = previousFrame;

		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Đăng kí");

		JLabel taotaikhoan_label = new JLabel("Tạo tài khoản");
		taotaikhoan_label.setBounds(119, 80, 100, 13);
		contentPane.add(taotaikhoan_label);

		JLabel taomatkhau_label = new JLabel("Tạo mật khẩu");
		taomatkhau_label.setBounds(119, 143, 100, 13);
		contentPane.add(taomatkhau_label);

		nhaplaimatkhau_label = new JLabel("Nhập lại mật khẩu");
		nhaplaimatkhau_label.setBounds(119, 209, 100, 13);
		contentPane.add(nhaplaimatkhau_label);

		taotaikhoan_txtfield = new JTextField();
		taotaikhoan_txtfield.setToolTipText(
				"Tài khoản không được bắt đầu bằng kí tự đặc biệt hay chữ số, độ dài không quá 20 kí tự.");
		taotaikhoan_txtfield.setBounds(267, 72, 178, 30);
		contentPane.add(taotaikhoan_txtfield);
		taotaikhoan_txtfield.setColumns(10);

		taomatkhau_txtfield = new JTextField();
		taomatkhau_txtfield.setToolTipText(
				"Mật khẩu không được chứa kí tự đặc biệt, chỉ được chứa kí tự hoặc số, độ dài không quá 20 kí tự.");
		taomatkhau_txtfield.setColumns(10);
		taomatkhau_txtfield.setBounds(267, 135, 178, 30);
		contentPane.add(taomatkhau_txtfield);

		nhaplaimatkhau_txtfield = new JTextField();
		nhaplaimatkhau_txtfield.setToolTipText(
				"Mật khẩu không được chứa kí tự đặc biệt, chỉ được chứa kí tự hoặc số, độ dài không quá 20 kí tự.");
		nhaplaimatkhau_txtfield.setColumns(10);
		nhaplaimatkhau_txtfield.setBounds(267, 201, 178, 30);
		contentPane.add(nhaplaimatkhau_txtfield);

		JButton xacnhan_btn = new JButton("Xác nhận đăng kí");
		xacnhan_btn.setBounds(204, 270, 136, 30);
		xacnhan_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				error_label.setText(Validation.validateAccountInput(taotaikhoan_txtfield.getText(), 1));
				error_label_1.setText(Validation.validatePasswordInput(taomatkhau_txtfield.getText()));
				error_label_2.setText(Validation.validatePasswordInput(nhaplaimatkhau_txtfield.getText()));

				if (error_label.getText() == null && error_label_1.getText() == null && error_label_2.getText() == null) {
					System.out.println("Xác nhận đầu vào hợp lệ!");
					if (taomatkhau_txtfield.getText().equals(nhaplaimatkhau_txtfield.getText())) {
						UserModel userModel = new UserModel();
						userModel.create(
								new User("0", taotaikhoan_txtfield.getText(), nhaplaimatkhau_txtfield.getText()));
						System.out.println("Đã tạo thành công user mới!!");
					} else {
						error_label_1.setText("Mật khẩu nhập không trùng nhau!");
						error_label_2.setText("Mật khẩu nhập không trùng nhau!");
					}
				}

			}
		});
		contentPane.add(xacnhan_btn);

		JButton quaylai_btn = new JButton("<=");
		quaylai_btn.setBounds(10, 10, 53, 30);
		quaylai_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				previousFrame.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(quaylai_btn);

		error_label = new JLabel("");
		error_label.setForeground(new Color(255, 0, 0));
		error_label.setBounds(267, 59, 243, 13);
		contentPane.add(error_label);

		error_label_1 = new JLabel("");
		error_label_1.setForeground(Color.RED);
		error_label_1.setBounds(267, 123, 243, 13);
		contentPane.add(error_label_1);

		error_label_2 = new JLabel("");
		error_label_2.setForeground(Color.RED);
		error_label_2.setBounds(267, 188, 243, 13);
		contentPane.add(error_label_2);

	}
}
