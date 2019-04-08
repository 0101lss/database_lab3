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
		setTitle("�û���Ϣ");
		table=PersonnelSystem.showuser();
		}
		else if(s.equals("logs")) {
			setTitle("��־��Ϣ");
		table=PersonnelSystem.showlogs();
		}
		else if(s.equals("family")) {
			setTitle("��ͥ��Ա��Ϣ");
			table=PersonnelSystem.showfamily();
		}
		else if(s.equals("employee")) {
			setTitle("ְ��������Ϣ");
			table=PersonnelSystem.showemployee();
		}
		else if(s.equals("exp")) {
			setTitle("����������Ϣ");
			table=PersonnelSystem.showexp();
		}
		else if(s.equals("course")) {
			setTitle("�γ���Ϣ");
			table=PersonnelSystem.showcourse();
		}
		else if(s.equals("choosecourse")) {
			setTitle("ѡ����Ϣ");
			table=PersonnelSystem.showchoosecourse();
		}
		else if(s.equals("department")) {
			setTitle("������Ϣ");
			table=PersonnelSystem.showdepartment();
		}
		else if(s.equals("duty")) {
			setTitle("ְ����Ϣ");
			table=PersonnelSystem.showduty();
		}
		else if(s.equals("record")) {
			setTitle("������Ϣ");
			table=PersonnelSystem.showrecord();
		}
		else if(s.equals("evaluate")) {
			setTitle("������Ϣ");
			table=PersonnelSystem.showevaluate();
		}
		else if(s.equals("salary")) {
			setTitle("������Ϣ");
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
