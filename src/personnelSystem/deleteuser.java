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

public class deleteuser {
private JFrame frame;
	
	public JFrame getFrame()
	{
		return frame;
	}
	public deleteuser() throws ClassNotFoundException, SQLException {
		initialize();
	}
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setTitle("ɾ���û�����");
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(200,200,450,300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTextField textField;
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setFont(new Font("����", Font.PLAIN, 20));
		textPane.setText(" �û���");
		textPane.setBounds(45, 42, 93, 32);
		frame.getContentPane().add(textPane);
		//��������ı���
		textField = new JTextField();
		textField.setBounds(148, 42, 178, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextField textField1;
		JTextPane textPane1 = new JTextPane();
		textPane1.setBackground(SystemColor.control);
		textPane1.setFont(new Font("����", Font.PLAIN, 20));
		textPane1.setText(" ����Ա");
		textPane1.setBounds(45, 94, 93, 32);
		frame.getContentPane().add(textPane1);
		//��������ı���
		textField1 = new JTextField();
		textField1.setBounds(148, 94, 178, 32);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		 JButton btnNewButton = new JButton("ȷ��");
		   btnNewButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent l) {
				   String num1=textField.getText();
				   String num2=textField1.getText();
				   try {
					   int n=-1;
					n=PersonnelSystem.deleteuser(num1,num2);
					if(n==1)
					JOptionPane.showMessageDialog(btnNewButton,"ɾ���ɹ�");
					else
						JOptionPane.showMessageDialog(btnNewButton,"ɾ��ʧ�ܣ����û�������");	
					textField.setText("");
					textField1.setText("");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"ɾ��ʧ��","Error", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField1.setText("");
					e.printStackTrace();					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnNewButton,"����������Լ����ɾ��ʧ��","Error", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField1.setText("");
					e.printStackTrace();
				}
			   }
		   });
		   btnNewButton.setBounds(172, 150, 111, 38);
			frame.getContentPane().add(btnNewButton);
frame.getContentPane().setLayout(null);
	}
}
