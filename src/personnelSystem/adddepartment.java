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
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class adddepartment {
	private JFrame frame;
//	private JPasswordField passwordField;
//	private JTable table=null;
//	private JFrame frame1;
//	private JTextField textField;
	
	public JFrame getFrame()
	{
		return frame;
	}
	public adddepartment() throws ClassNotFoundException, SQLException {
		initialize();
	}
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setTitle("��Ӳ�����Ϣ����");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(200,200,450,400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					JTextField textField;
					JTextField textField1;	
					JTextField textField2;	
					JTextPane textPane = new JTextPane();
					textPane.setBackground(SystemColor.control);
					textPane.setFont(new Font("����", Font.PLAIN, 20));
					textPane.setText("���ź�");
					textPane.setBounds(45, 42, 105, 32);
					frame.getContentPane().add(textPane);
					//��������ı���
					textField = new JTextField();
					textField.setBounds(148, 42, 178,32);
					frame.getContentPane().add(textField);
					textField.setColumns(10);
					
					JTextPane textPane1 = new JTextPane();
					textPane1.setBackground(SystemColor.control);
					textPane1.setFont(new Font("����", Font.PLAIN, 20));
					textPane1.setText("������");
					textPane1.setBounds(45, 94, 85, 32);
					frame.getContentPane().add(textPane1);
					//��������ı���
					textField1 = new JTextField();
					textField1.setBounds(148, 94, 178, 32);
					frame.getContentPane().add(textField1);
					textField1.setColumns(10);
					
					JTextPane textPane2 = new JTextPane();
					textPane2.setBackground(SystemColor.control);
					textPane2.setFont(new Font("����", Font.PLAIN, 20));
					textPane2.setText("����Ա");
					textPane2.setBounds(45, 146,105, 32);
					frame.getContentPane().add(textPane2);
					//��������ı���
					textField2 = new JTextField();
					textField2.setBounds(148, 146, 178, 32);
					frame.getContentPane().add(textField2);
					textField2.setColumns(10);
									   			   
				   JButton btnNewButton = new JButton("ȷ��");
				   btnNewButton.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent l) {
					   String num1=textField.getText();
						String num2=textField1.getText();
						String num3=textField2.getText();
					try {
						if(num1.equals("") || num2.equals("")) {
						JOptionPane.showMessageDialog(btnNewButton,"��Ϣ����Ϊ�������������룡","Error", JOptionPane.ERROR_MESSAGE);
						}else {
							PersonnelSystem.adddepartment(num1,num2,num3);
						JOptionPane.showMessageDialog(btnNewButton,"��ӳɹ�");
						}						
						textField.setText("");
						textField1.setText("");
						textField2.setText("");
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(btnNewButton,"���ź��Ѵ��ڻ�����Ϣδ�����������룡","Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						textField1.setText("");
						textField2.setText("");
					} }});
				   btnNewButton.setBounds(300,200, 111, 38);
					frame.getContentPane().add(btnNewButton);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
	}
}
