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

public class Useremployee {
	private JFrame frame;
//	private JPasswordField passwordField;
//	private JTable table=null;
//	private JFrame frame1;
//	private JTextField textField;
	
	public JFrame getFrame()
	{
		return frame;
	}
	public Useremployee(String ID) throws ClassNotFoundException, SQLException {
		initialize(ID);
	}
	private void initialize(String ID) throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setTitle("�޸�ְ����Ϣ���棨*Ϊ���ɸ��");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(200,200,700,700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					JTextField textField1;
					JTextField textField2;
					JTextField textField3;
					JTextField textField4;
					JTextField textField5;
					JTextField textField6;
					JTextField textField7;
					JTextField textField8;
					JTextField textField9;
					JTextField textField10;
					JTextField textField11;
					
//					JTextPane textPane = new JTextPane();
//					textPane.setBackground(SystemColor.control);
//					textPane.setFont(new Font("����", Font.PLAIN, 20));
//					textPane.setText("ְ����*");
//					textPane.setBounds(45, 42, 105, 32);
//					frame.getContentPane().add(textPane);
//					//��������ı���
//					textField = new JTextField();
//					textField.setBounds(148, 42, 178,32);
//					frame.getContentPane().add(textField);
//					textField.setColumns(10);
					
					JTextPane textPane1 = new JTextPane();
					textPane1.setBackground(SystemColor.control);
					textPane1.setFont(new Font("����", Font.PLAIN, 20));
					textPane1.setText(" ����*");
					textPane1.setBounds(55, 94, 85, 32);
					frame.getContentPane().add(textPane1);
					//��������ı���
					textField1 = new JTextField();
					textField1.setBounds(148, 94, 178, 32);
					frame.getContentPane().add(textField1);
					textField1.setColumns(10);
					
					JTextPane textPane2 = new JTextPane();
					textPane2.setBackground(SystemColor.control);
					textPane2.setFont(new Font("����", Font.PLAIN, 20));
					textPane2.setText("���֤��*");
					textPane2.setBounds(25, 146,120, 32);
					frame.getContentPane().add(textPane2);
					//��������ı���
					textField2 = new JTextField();
					textField2.setBounds(148, 146, 178, 32);
					frame.getContentPane().add(textField2);
					textField2.setColumns(10);
					
					JTextPane textPane3 = new JTextPane();
					textPane3.setBackground(SystemColor.control);
					textPane3.setFont(new Font("����", Font.PLAIN, 20));
					textPane3.setText(" �Ա�");
					textPane3.setBounds(45, 198, 83, 32);
					frame.getContentPane().add(textPane3);
					//��������ı���
				   textField3 = new JTextField();
				   textField3.setBounds(148, 198, 178, 32);
				   frame.getContentPane().add(textField3);
				   textField3.setColumns(10);
				   
				   JTextPane textPane4 = new JTextPane();
					textPane4.setBackground(SystemColor.control);
					textPane4.setFont(new Font("����", Font.PLAIN, 20));
					textPane4.setText(" ����");
					textPane4.setBounds(45, 250, 83, 32);
					frame.getContentPane().add(textPane4);
					//��������ı���
				   textField4 = new JTextField();
				   textField4.setBounds(148, 250, 178, 32);
				   frame.getContentPane().add(textField4);
				   textField4.setColumns(10);
				   
				   JTextPane textPane5 = new JTextPane();
					textPane5.setBackground(SystemColor.control);
					textPane5.setFont(new Font("����", Font.PLAIN, 20));
					textPane5.setText(" ����");
					textPane5.setBounds(45, 302, 83, 32);
					frame.getContentPane().add(textPane5);
					//��������ı���
				   textField5 = new JTextField();
				   textField5.setBounds(148, 302, 178, 32);
				   frame.getContentPane().add(textField5);
				   textField5.setColumns(10);
				   
				   JTextPane textPane6 = new JTextPane();
					textPane6.setBackground(SystemColor.control);
					textPane6.setFont(new Font("����", Font.PLAIN, 20));
					textPane6.setText(" ���ź�");
					textPane6.setBounds(35, 354, 93, 32);
					frame.getContentPane().add(textPane6);
					//��������ı���
				   textField6 = new JTextField();
				   textField6.setBounds(148, 354, 178, 32);
				   frame.getContentPane().add(textField6);
				   textField6.setColumns(10);
				   
				   JTextPane textPane7 = new JTextPane();
					textPane7.setBackground(SystemColor.control);
					textPane7.setFont(new Font("����", Font.PLAIN, 20));
					textPane7.setText(" ְ���");
					textPane7.setBounds(343, 94, 83, 32);
					frame.getContentPane().add(textPane7);
					//��������ı���
				   textField7 = new JTextField();
				   textField7.setBounds(450, 94, 178, 32);
				   frame.getContentPane().add(textField7);
				   textField7.setColumns(10);
				   
				   JTextPane textPane8= new JTextPane();
					textPane8.setBackground(SystemColor.control);
					textPane8.setFont(new Font("����", Font.PLAIN, 20));
					textPane8.setText(" ����");
					textPane8.setBounds(353, 146, 83, 32);
					frame.getContentPane().add(textPane8);
					//��������ı���
				   textField8= new JTextField();
				   textField8.setBounds(450, 146, 178, 32);
				   frame.getContentPane().add(textField8);
				   textField8.setColumns(10);
				   
				   JTextPane textPane9 = new JTextPane();
					textPane9.setBackground(SystemColor.control);
					textPane9.setFont(new Font("����", Font.PLAIN, 20));
					textPane9.setText(" ������ò");
					textPane9.setBounds(333,198, 110, 32);
					frame.getContentPane().add(textPane9);
					//��������ı���
				   textField9 = new JTextField();
				   textField9.setBounds(450, 198, 178, 32);
				   frame.getContentPane().add(textField9);
				   textField9.setColumns(10);
				   
				   JTextPane textPane10 = new JTextPane();
					textPane10.setBackground(SystemColor.control);
					textPane10.setFont(new Font("����", Font.PLAIN, 20));
					textPane10.setText(" ����״��");
					textPane10.setBounds(333, 250, 110, 32);
					frame.getContentPane().add(textPane10);
					//��������ı���
				   textField10 = new JTextField();
				   textField10.setBounds(450, 250, 178, 32);
				   frame.getContentPane().add(textField10);
				   textField10.setColumns(10);
				   
				   JTextPane textPane11 = new JTextPane();
					textPane11.setBackground(SystemColor.control);
					textPane11.setFont(new Font("����", Font.PLAIN, 20));
					textPane11.setText(" ��Ӷʱ��");
					textPane11.setBounds(333, 302, 110, 32);
					frame.getContentPane().add(textPane11);
					//��������ı���
				   textField11 = new JTextField();
				   textField11.setBounds(450, 302, 178, 32);
				   frame.getContentPane().add(textField11);
				   textField11.setColumns(10);
				   
//				   JTextPane textPane12 = new JTextPane();
//					textPane12.setBackground(SystemColor.control);
//					textPane12.setFont(new Font("����", Font.PLAIN, 18));
//					textPane12.setText(" ¼����Ա*");
//					textPane12.setBounds(333, 302, 110, 32);
//					frame.getContentPane().add(textPane12);
//					//��������ı���
//				   textField12 = new JTextField();
//				   textField12.setBounds(450, 302, 178, 32);
//				   frame.getContentPane().add(textField12);
//				   textField12.setColumns(10);
				   			   
				   JButton btnNewButton = new JButton("ȷ��");
				   btnNewButton.addActionListener(new ActionListener() {
					   public void actionPerformed(ActionEvent l) {
						String num2=textField1.getText();
				   String num3=textField2.getText();
				   String num4=textField3.getText();
				   String num5=textField4.getText();
				   String num6=textField5.getText();
				   String num7=textField6.getText();
				   String num8=textField7.getText();
				   String num9=textField8.getText();
				   String num10=textField9.getText();
				   String num11=textField10.getText();
				   String num12=textField11.getText();
//				   String num13=textField12.getText();
				 //  System.out.println(num1+"\n"+num2+"\n"+num3+"\n"+num4+"\n"+num5+"\n"+num6+"\n"+num7+"\n"+num8+"\n"+num9+"\n"+num10+"\n"+num11+"\n"+num12+"\n"+num13);
					try {
						if(num2.equals("") || num3.equals(" ")) {
							JOptionPane.showMessageDialog(btnNewButton,"��*��Ϣ���ܸ��������������룡","Error", JOptionPane.ERROR_MESSAGE);
							}
						else {
					   PersonnelSystem.changeemployee(ID,num2,num3,num4,num5,num6,num7,num8,num9,num10,num11,num12,"no");
						JOptionPane.showMessageDialog(btnNewButton,"�޸ĳɹ�");
							}				
				//		textField.setText("");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
						textField4.setText("");
						textField5.setText("");
						textField6.setText("");
						textField7.setText("");
						textField8.setText("");
						textField9.setText("");
						textField10.setText("");
						textField11.setText("");
				//		textField12.setText(""); // 
					} catch (ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(btnNewButton,"�޷��޸����������룡","Error", JOptionPane.ERROR_MESSAGE);
				//		textField.setText("");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
						textField4.setText("");
						textField5.setText("");
						textField6.setText("");
						textField7.setText("");
						textField8.setText("");
						textField9.setText("");
						textField10.setText("");
						textField11.setText("");
				//		textField12.setText("");
					} }});
				   btnNewButton.setBounds(200, 400, 111, 38);
					frame.getContentPane().add(btnNewButton);
					   
					   JButton btnNewButton1 = new JButton("�鿴");
					   btnNewButton1.addActionListener(new ActionListener() {
						   public void actionPerformed(ActionEvent l) {
					//	   String num1=textField.getText();
						try {
							ArrayList<String> list=PersonnelSystem.searchemployeebyID(ID);
							//System.out.println(list.toString());
							if(list.size()==12) {
							textField1.setText(list.get(0));
							textField2.setText(list.get(1));
							if(list.get(2)!="")
							textField3.setText(list.get(2));
							if(list.get(3)!="")
							textField4.setText(list.get(3));
							if(list.get(4)!="")
							textField5.setText(list.get(4));
							if(list.get(5)!="")
							textField6.setText(list.get(5));
							if(list.get(6)!="")
							textField7.setText(list.get(6));
							if(list.get(7)!="")
							textField8.setText(list.get(7));
							if(list.get(8)!="")
							textField9.setText(list.get(8));
							if(list.get(9)!="")
							textField10.setText(list.get(9));
							if(list.get(10)!="")
							textField11.setText(list.get(10));
//							if(list.get(11)!="")
//							textField12.setText(list.get(11));
							}
							else
							JOptionPane.showMessageDialog(btnNewButton1,"ְ���������������������룡","Error", JOptionPane.ERROR_MESSAGE);
						} catch (ClassNotFoundException | SQLException e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(btnNewButton1,"ְ���������������������룡","Error", JOptionPane.ERROR_MESSAGE);
				//			textField.setText("");
						} }});
					   btnNewButton1.setBounds(400, 400, 111, 38);
						frame.getContentPane().add(btnNewButton1);
		                frame.getContentPane().setLayout(null);
	}
}
