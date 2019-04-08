package personnelSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class changepasswd{
	private JFrame frame;
	
	public JFrame getFrame()
	{
		return frame;
	}
	public changepasswd() throws ClassNotFoundException, SQLException {
		initialize();
	}
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setTitle("修改用户密码界面");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("微软雅黑", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(200,200,500,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					JTextField textField;
					JPasswordField textField1;
					JPasswordField textField2;
					JTextField textField3;
					JTextPane textPane = new JTextPane();
					textPane.setBackground(SystemColor.control);
					textPane.setFont(new Font("宋体", Font.PLAIN, 22));
					textPane.setText(" 用户名");
					textPane.setBounds(45, 42, 93, 32);
					frame.getContentPane().add(textPane);
					//添加输入文本框
					textField = new JTextField();
					textField.setBounds(148, 42, 178, 32);
					frame.getContentPane().add(textField);
					textField.setColumns(10);
					JTextPane textPane1 = new JTextPane();
					textPane1.setBackground(SystemColor.control);
					textPane1.setFont(new Font("宋体", Font.PLAIN, 22));
					textPane1.setText(" 新密码");
					textPane1.setBounds(55, 94, 85, 32);
					frame.getContentPane().add(textPane1);
					//添加输入文本框
					textField1 = new JPasswordField();
					textField1.setBounds(148, 94, 178, 32);
					frame.getContentPane().add(textField1);
					textField1.setColumns(10);
					JTextPane textPane2 = new JTextPane();
					textPane2.setBackground(SystemColor.control);
					textPane2.setFont(new Font("宋体", Font.PLAIN, 22));
					textPane2.setText(" 确认密码");
					textPane2.setBounds(25, 146, 120,32);
					frame.getContentPane().add(textPane2);
					//添加输入文本框
					textField2 = new JPasswordField();
					textField2.setBounds(148, 146, 178, 32);
					frame.getContentPane().add(textField2);
					textField2.setColumns(10);
					JTextPane textPane3 = new JTextPane();
					textPane3.setBackground(SystemColor.control);
					textPane3.setFont(new Font("宋体", Font.PLAIN, 22));
					textPane3.setText(" 管理员号");
					textPane3.setBounds(25, 198, 120,32);
					frame.getContentPane().add(textPane3);
					//添加输入文本框
				   textField3 = new JTextField();
				   textField3.setBounds(148, 198, 178, 32);
				   frame.getContentPane().add(textField3);
				   textField3.setColumns(10);
				   JButton btnNewButton = new JButton("确定");
				   btnNewButton.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent l) {
					   String num1=textField.getText();
					   char[] password =textField1.getPassword();
						String num2=new String(password);
						char[] password1 =textField2.getPassword();
						String num3=new String(password1);
						if(!num3.equals(num2)) {
						JOptionPane.showMessageDialog(btnNewButton,"两次密码不一样请重新输入！","Error", JOptionPane.ERROR_MESSAGE);
						}
				   String num4=textField3.getText();
					try {
						PersonnelSystem.changeuserpwd(num1,num2,num4);
						JOptionPane.showMessageDialog(btnNewButton,"修改成功");
						textField.setText("");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(btnNewButton,"用户不存在或管理员不存在请重新输入！","Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
					} }});
				   btnNewButton.setBounds(172, 300, 111, 38);
					frame.getContentPane().add(btnNewButton);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
	}
}
