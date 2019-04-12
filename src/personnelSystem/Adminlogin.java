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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Adminlogin {
	private JFrame frame;
	private JMenuBar jmb;	//定义菜单栏
	private JMenu jm1,jm2,jm3,jm4,jm5;	//定义菜单
//	private JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5,jmi6,jmi7,jmi8,jmi9,jmi10,jmi11,jmi12,jmi13,jmi14,jmi15,
//	jmi16,jmi17,jmi18,jmi19,jmi20,jmi21,jmi22,jmi23,jmi24,jmi25,jmi26,jmi27,jmi28
//	,jmi29,jmi30,jmi31,jmi32,jmi33,jmi34,jmi35,jmi36,jmi37,jmi38,jmi39,jmi40,jmi41;		//定义子菜单
	private JMenuItem jmi1,jmi2,jmi3,jmi4,jmi9,jmi10,jmi17,jmi18,jmi25,jmi26,jmi27,jmi28
	,jmi29,jmi30,jmi31,jmi32,jmi33,jmi34,jmi35,jmi36,jmi37,jmi38,jmi39,jmi40,jmi41;		//定义子菜单

	public JFrame getFrame()
	{
		return frame;
	}
	public Adminlogin() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jmb=new JMenuBar();
        jm1=new JMenu("添加");
        jm2=new JMenu("查询");
        jm3=new JMenu("删除");
        jm4=new JMenu("修改");
        jm5=new JMenu("查看");
        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm3);
        jmb.add(jm4);
        jmb.add(jm5);
        jmi1=new JMenuItem("用户");
        jmi2=new JMenuItem("职工");
        jmi3=new JMenuItem("部门");
        jmi4=new JMenuItem("工资");
//        jmi5=new JMenuItem("课程");
//        jmi6=new JMenuItem("选课");
//        jmi7=new JMenuItem("考勤信息");
//        jmi8=new JMenuItem("考评信息");
        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);
//        jm1.add(jmi4);
//        jm1.add(jmi5);
//        jm1.add(jmi6);
//        jm1.add(jmi7);
//        jm1.add(jmi8);
        jmi9=new JMenuItem("用户");
        jmi10=new JMenuItem("职工");
//        jmi11=new JMenuItem("部门");
//        jmi12=new JMenuItem("工资");
//        jmi13=new JMenuItem("课程");
//        jmi14=new JMenuItem("选课");
//        jmi15=new JMenuItem("考勤信息");
//        jmi16=new JMenuItem("考评信息");
        jm3.add(jmi9);
        jm3.add(jmi10);
//        jm3.add(jmi11);
//        jm3.add(jmi12);
//        jm3.add(jmi13);
//        jm3.add(jmi14);
//        jm3.add(jmi15);
//        jm3.add(jmi16);
        jmi17=new JMenuItem("用户密码");
        jmi18=new JMenuItem("职工");
//        jmi19=new JMenuItem("部门");
//        jmi20=new JMenuItem("工资");
//        jmi21=new JMenuItem("课程");
//        jmi22=new JMenuItem("选课");
//        jmi23=new JMenuItem("考勤信息");
//        jmi24=new JMenuItem("考评信息");
        jm4.add(jmi17);
        jm4.add(jmi18);
        jm4.add(jmi4);
//        jm4.add(jmi19);
//        jm4.add(jmi20);
//        jm4.add(jmi21);
//        jm4.add(jmi22);
//        jm4.add(jmi23);
//        jm4.add(jmi24);
        jmi29=new JMenuItem("用户");
        jmi30=new JMenuItem("职工");
        jmi31=new JMenuItem("部门");
        jmi32=new JMenuItem("工资");
        jmi33=new JMenuItem("课程");
        jmi34=new JMenuItem("选课");
        jmi35=new JMenuItem("考勤信息");
        jmi36=new JMenuItem("考评信息");
        jmi25=new JMenuItem("家庭成员");
        jmi26=new JMenuItem("工作经历");
        jmi27=new JMenuItem("职务");
        jmi28=new JMenuItem("日志");
        jm5.add(jmi29);
        jm5.add(jmi30);
        jm5.add(jmi31);
        jm5.add(jmi32);
        jm5.add(jmi33);
        jm5.add(jmi34);
        jm5.add(jmi35);
        jm5.add(jmi36);
        jm5.add(jmi25);
        jm5.add(jmi26);
        jm5.add(jmi27);
        jm5.add(jmi28);
        jmi37=new JMenuItem("查询1(连接查询)");
        jmi38=new JMenuItem("查询2(分组查询:每个部门的平均工资)");
        jmi39=new JMenuItem("查询3(嵌套查询:选择了全部课程的员工号和姓名)");
        jmi40=new JMenuItem("查询4(分组查询)");
        jmi41=new JMenuItem("查询5(用视图进行查询)");
        jm2.add(jmi37);
        jm2.add(jmi38);
        jm2.add(jmi39);
        jm2.add(jmi40);
        jm2.add(jmi41);
		frame = new JFrame();
		frame.setTitle("公司人事管理系统(管理员界面)");
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
					adduserInformation window = new adduserInformation();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addemployee window = new addemployee();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					adddepartment window = new adddepartment();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changesalary window = new changesalary();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
          deleteuser window=new deleteuser();
          window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
          deleteemployee window=new deleteemployee();
          window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changepasswd window = new changepasswd();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changeemployee window = new changeemployee();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("user");
//					JTable table=PersonnelSystem.showuser();
//					frame.add(new JScrollPane(table));
//					frame.setLocationRelativeTo(null); 
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
				
		jmi25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("family");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("exp");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("employee");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("department");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("salary");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("course");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("choosecourse");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("record");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("evaluate");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
				
		jmi37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				searchone window=new searchone();
				window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		

		jmi38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFrame frame1=new JFrame("查询2结果");
					JTable table=PersonnelSystem.searchtwo();
					frame1.add(new JScrollPane(table));
					frame1.setSize(400, 300); 
					frame1.setLocationRelativeTo(null); 
					frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame1.setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFrame frame1=new JFrame("查询3结果");
					JTable table=PersonnelSystem.searchthree();
					frame1.add(new JScrollPane(table));
					frame1.setSize(400, 300); 
					frame1.setLocationRelativeTo(null); 
					frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame1.setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchfour window=new searchfour();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchfive window=new searchfive();
					window.getFrame().setVisible(true);
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
					
		jmi27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("duty");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
		
		jmi28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new showInformation("logs");
//					JTable table=PersonnelSystem.showlogs();
//					frame.add(new JScrollPane(table));
//					frame.setLocationRelativeTo(null); 
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}});
	}
}
