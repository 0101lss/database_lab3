package personnelSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Userlogin {
	private JFrame frame;
	private JMenuBar jmb;	//����˵���
	public JFrame getFrame()
	{
		return frame;
	}
	public Userlogin(String ID) {
		initialize(ID);
	}
	private void initialize(String ID) {
		jmb=new JMenuBar();
       JMenu jm1=new JMenu("������Ϣ");
       JMenu jm2=new JMenu("�γ���Ϣ");
       JMenu jm3=new JMenu("���˱���");
       jmb.add(jm1);
       jmb.add(jm2);
       jmb.add(jm3);
       JMenuItem jmi1=new JMenuItem("������Ϣ(���޸�)");
       JMenuItem jmi2=new JMenuItem("��ͥ��Ա");
       JMenuItem jmi3=new JMenuItem("��������");
       JMenuItem jmi14=new JMenuItem("������Ϣ");
       jm1.add(jmi1);
       jm1.add(jmi2);
       jm1.add(jmi3);
       jm1.add(jmi14);
       JMenuItem jmi4=new JMenuItem("ѡ�������ɼ�");
       JMenuItem jmi5=new JMenuItem("ƽ����������");
       jm2.add(jmi4);
       jm2.add(jmi5);
       JMenuItem jmi6=new JMenuItem("�������");
       JMenuItem jmi7=new JMenuItem("�������");
       jm3.add(jmi6);
       jm3.add(jmi7);
       
       frame = new JFrame();
		frame.setTitle("��˾���¹���ϵͳ(�����û����棩");
		frame.setJMenuBar(jmb);
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("΢���ź�", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setFont(null);
		frame.setBackground(Color.GRAY);
		frame.setBounds(300, 200,650,300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       jmi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Useremployee window = new Useremployee(ID);
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
       
       jmi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				new Userinformation(ID, "family");	
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
        
       jmi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				new Userinformation(ID, "exp");	
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
       
       jmi14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				new Userinformation(ID, "salary");	
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
       
       jmi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				new Userinformation(ID, "choosecourse");	
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
       
       jmi5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				new Userinformation(ID, "gradeorder");	
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
       
       jmi6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				new Userinformation(ID, "record");	
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
       
       jmi7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				new Userinformation(ID, "evaluate");	
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
       
	}
}
