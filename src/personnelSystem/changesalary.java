package personnelSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class changesalary  {
	private JFrame frame;
	private String num11="";
//	private JPasswordField passwordField;
//	private JTable table=null;
//	private JFrame frame1;
//	private JTextField textField;
	
	public JFrame getFrame()
	{
		return frame;
	}
	public changesalary() throws ClassNotFoundException, SQLException {
		initialize();
	}
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setTitle("�޸�ְ�����ʽ��棨*����Ϊ�գ�");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(200,200,700,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					JTextField textField;
					JTextField textField1;
					JTextField textField2;
					JTextField textField3;
					JTextField textField7;
					JTextField textField8;
					JTextField textField9;
					
					JTextPane textPane = new JTextPane();
					textPane.setBackground(SystemColor.control);
					textPane.setFont(new Font("����", Font.PLAIN, 20));
					textPane.setText(" ְ����*");
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
					textPane1.setText(" ��������");
					textPane1.setBounds(25, 94,120, 32);
					frame.getContentPane().add(textPane1);
					//��������ı���
					textField1 = new JTextField();
					textField1.setBounds(148, 94, 178, 32);
					frame.getContentPane().add(textField1);
					textField1.setColumns(10);
					
					JTextPane textPane2 = new JTextPane();
					textPane2.setBackground(SystemColor.control);
					textPane2.setFont(new Font("����", Font.PLAIN, 20));
					textPane2.setText(" ��λ����");
					textPane2.setBounds(35, 146,120, 32);
					frame.getContentPane().add(textPane2);
					//��������ı���
					textField2 = new JTextField();
					textField2.setBounds(148, 146, 178, 32);
					frame.getContentPane().add(textField2);
					textField2.setColumns(10);
					
					JTextPane textPane3 = new JTextPane();
					textPane3.setBackground(SystemColor.control);
					textPane3.setFont(new Font("����", Font.PLAIN, 20));
					textPane3.setText(" ����");
					textPane3.setBounds(45, 198, 83, 32);
					frame.getContentPane().add(textPane3);
					//��������ı���
				   textField3 = new JTextField();
				   textField3.setBounds(148, 198, 178, 32);
				   frame.getContentPane().add(textField3);
				   textField3.setColumns(10);
				   		   
				   JTextPane textPane7 = new JTextPane();
					textPane7.setBackground(SystemColor.control);
					textPane7.setFont(new Font("����", Font.PLAIN, 20));
					textPane7.setText(" ���Ͻ�");
					textPane7.setBounds(343, 42, 83, 32);
					frame.getContentPane().add(textPane7);
					//��������ı���
				   textField7 = new JTextField();
				   textField7.setBounds(450, 42, 178, 32);
				   frame.getContentPane().add(textField7);
				   textField7.setColumns(10);
				   
				   JTextPane textPane8= new JTextPane();
					textPane8.setBackground(SystemColor.control);
					textPane8.setFont(new Font("����", Font.PLAIN, 20));
					textPane8.setText(" ��˰");
					textPane8.setBounds(353, 94, 83, 32);
					frame.getContentPane().add(textPane8);
					//��������ı���
				   textField8= new JTextField();
				   textField8.setBounds(450, 94, 178, 32);
				   frame.getContentPane().add(textField8);
				   textField8.setColumns(10);
				   
				   JTextPane textPane9 = new JTextPane();
					textPane9.setBackground(SystemColor.control);
					textPane9.setFont(new Font("����", Font.PLAIN, 20));
					textPane9.setText(" ����Ա");
					textPane9.setBounds(333,146, 110, 32);
					frame.getContentPane().add(textPane9);
					//��������ı���
				   textField9 = new JTextField();
				   textField9.setBounds(450, 146, 178, 32);
				   frame.getContentPane().add(textField9);
				   textField9.setColumns(10);
				   JButton btnNewButton = new JButton("ȷ��");
				   btnNewButton.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent l) {
					   String num1=textField.getText();
					   System.out.println(num1);
						String num2=textField1.getText();
				   String num3=textField2.getText();
				   String num4=textField3.getText();
				   String num8=textField7.getText();
				   String num9=textField8.getText();
				   String num10=textField9.getText();
					try {
						if(!num1.equals(num11)) {
						JOptionPane.showMessageDialog(btnNewButton,"*����Ϣ�����޸������������룡","Error", JOptionPane.ERROR_MESSAGE);
						}else {
							PersonnelSystem.changesalary(num1,num2,num3,num4,num8,num9,num10);
						JOptionPane.showMessageDialog(btnNewButton,"�޸ĳɹ�");
						}						
						textField.setText("");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
						textField7.setText("");
						textField8.setText("");
						textField9.setText("");
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(btnNewButton,"ְ�������Ѵ��ڻ�����Ϣδ�����������룡","Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
						textField7.setText("");
						textField8.setText("");
						textField9.setText("");
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(btnNewButton,"������Ϣ��д����������������룡","Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
						textField7.setText("");
						textField8.setText("");
						textField9.setText("");
					}
					}});
				   btnNewButton.setBounds(200, 300, 111, 38);
					frame.getContentPane().add(btnNewButton);
					
					JButton btnNewButton1 = new JButton("�鿴");
					   btnNewButton1.addActionListener(new ActionListener() {
						   public void actionPerformed(ActionEvent l) {
						   String num1=textField.getText();
						   num11=num1;
						try {
							ArrayList<String> list=PersonnelSystem.searchsalarybyID(num1);
							//System.out.println(list.toString());
							if(list.size()==7) {
							textField1.setText(list.get(0));
							if(list.get(1)!="")
							textField2.setText(list.get(1));
							if(list.get(2)!="")
							textField3.setText(list.get(2));
							if(list.get(3)!="")
							textField7.setText(list.get(3));
							if(list.get(5)!="")
							textField8.setText(list.get(5));
							}
							else
							JOptionPane.showMessageDialog(btnNewButton1,"ְ���Ų��������������룡","Error", JOptionPane.ERROR_MESSAGE);
						} catch (ClassNotFoundException | SQLException e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(btnNewButton1,"ְ���Ų��������������룡","Error", JOptionPane.ERROR_MESSAGE);
							textField.setText("");
						} }});
					   btnNewButton1.setBounds(400,300, 111, 38);
					   frame.getContentPane().add(btnNewButton1);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
	}
}

