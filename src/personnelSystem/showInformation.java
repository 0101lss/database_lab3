package personnelSystem;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class showInformation extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6612976492439956169L;
	private JTable table=null;
	public showInformation(String s) {
	try {	
		if(s.equals("user")) {		
		setTitle("用户信息");
		table=PersonnelSystem.showuser();
		}
		else if(s.equals("logs")) {
			setTitle("日志信息");
		table=PersonnelSystem.showlogs();
		}
		else if(s.equals("family")) {
			setTitle("家庭成员信息");
			table=PersonnelSystem.showfamily();
		}
		else if(s.equals("employee")) {
			setTitle("职工基本信息");
			table=PersonnelSystem.showemployee();
		}
		else if(s.equals("exp")) {
			setTitle("工作经历信息");
			table=PersonnelSystem.showexp();
		}
		else if(s.equals("course")) {
			setTitle("课程信息");
			table=PersonnelSystem.showcourse();
		}
		else if(s.equals("choosecourse")) {
			setTitle("选课信息");
			table=PersonnelSystem.showchoosecourse();
		}
		else if(s.equals("department")) {
			setTitle("部门信息");
			table=PersonnelSystem.showdepartment();
		}
		else if(s.equals("duty")) {
			setTitle("职务信息");
			table=PersonnelSystem.showduty();
		}
		else if(s.equals("record")) {
			setTitle("考勤信息");
			table=PersonnelSystem.showrecord();
		}
		else if(s.equals("evaluate")) {
			setTitle("考评信息");
			table=PersonnelSystem.showevaluate();
		}
		else if(s.equals("salary")) {
			setTitle("工资信息");
			table=PersonnelSystem.showsalary();
		}
		add(new JScrollPane(table));
	   setSize(400, 300); 
	   setLocationRelativeTo(null); 
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setVisible(true);
	}catch (Exception e1) {
		e1.printStackTrace();
      }
	}
}
