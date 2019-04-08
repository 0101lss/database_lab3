package personnelSystem;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Userinformation extends JFrame {
	private static final long serialVersionUID = -6612976492439956169L;
	private JTable table=null;
	public Userinformation(String s,String s1) {
		try {	
			if(s1.equals("family")) {
				setTitle("你的家庭成员信息");
			table=PersonnelSystem.selectuserfamily(s);
			}
			else if(s1.equals("exp")) {
				setTitle("你的工作经历信息");
				table=PersonnelSystem.selectuserexp(s);
			}
			else if(s1.equals("choosecourse")) {
				setTitle("你的选课信息");
				table=PersonnelSystem.selectuserchoosecourse(s);
			}
			else if(s1.equals("record")) {
				setTitle("考勤信息");
				table=PersonnelSystem.selectuserrecord(s);
			}
			else if(s1.equals("evaluate")) {
				setTitle("考评信息");
				table=PersonnelSystem.selectevaluate(s);
			}
			else if(s1.equals("salary")) {
				setTitle("工资信息");
				table=PersonnelSystem.selectusersalary(s);
			}
			else if(s1.equals("gradeorder")) {
				setTitle("排名情况");
				table=PersonnelSystem.gradeorder(s);
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
