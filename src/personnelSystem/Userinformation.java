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
				setTitle("��ļ�ͥ��Ա��Ϣ");
			table=PersonnelSystem.selectuserfamily(s);
			}
			else if(s1.equals("exp")) {
				setTitle("��Ĺ���������Ϣ");
				table=PersonnelSystem.selectuserexp(s);
			}
			else if(s1.equals("choosecourse")) {
				setTitle("���ѡ����Ϣ");
				table=PersonnelSystem.selectuserchoosecourse(s);
			}
			else if(s1.equals("record")) {
				setTitle("������Ϣ");
				table=PersonnelSystem.selectuserrecord(s);
			}
			else if(s1.equals("evaluate")) {
				setTitle("������Ϣ");
				table=PersonnelSystem.selectevaluate(s);
			}
			else if(s1.equals("salary")) {
				setTitle("������Ϣ");
				table=PersonnelSystem.selectusersalary(s);
			}
			else if(s1.equals("gradeorder")) {
				setTitle("�������");
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
