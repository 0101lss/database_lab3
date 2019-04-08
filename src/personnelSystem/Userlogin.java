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
	private JMenuBar jmb;	//定义菜单栏
	public JFrame getFrame()
	{
		return frame;
	}
	public Userlogin(String ID) {
		initialize(ID);
	}
	private void initialize(String ID) {
		jmb=new JMenuBar();
       JMenu jm1=new JMenu("个人信息");
       JMenu jm2=new JMenu("课程信息");
       JMenu jm3=new JMenu("个人表现");
       jmb.add(jm1);
       jmb.add(jm2);
       jmb.add(jm3);
       JMenuItem jmi1=new JMenuItem("基本信息(可修改)");
       JMenuItem jmi2=new JMenuItem("家庭成员");
       JMenuItem jmi3=new JMenuItem("工作经历");
       JMenuItem jmi14=new JMenuItem("工资信息");
       jm1.add(jmi1);
       jm1.add(jmi2);
       jm1.add(jmi3);
       jm1.add(jmi14);
       JMenuItem jmi4=new JMenuItem("选课情况与成绩");
       JMenuItem jmi5=new JMenuItem("平均分排名表");
       jm2.add(jmi4);
       jm2.add(jmi5);
       JMenuItem jmi6=new JMenuItem("考勤情况");
       JMenuItem jmi7=new JMenuItem("考评情况");
       jm3.add(jmi6);
       jm3.add(jmi7);
       
       frame = new JFrame();
		frame.setTitle("公司人事管理系统(个人用户界面）");
		frame.setJMenuBar(jmb);
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("微软雅黑", Font.BOLD, 16));
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
