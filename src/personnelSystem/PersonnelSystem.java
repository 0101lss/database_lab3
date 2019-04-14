package personnelSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PersonnelSystem {
	public static Connection connection() throws SQLException, ClassNotFoundException{
		//1.加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.得到连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/personnel?serverTimezone=UTC","root","jmq.990467");
	      return conn;
	}
	public static int adminlogin(String ID,String psw) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		   String sql="select adminpwd from t_admin where AdminID='"+ID+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   if(rs.next()) 
		   {
			  if(rs.getString(1).equals(psw))
				  return 1;
				else
					return 0;
		   }
		return 0;
	}
	public static String Userlogin(String ID,String psw) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		   String sql="select tpasswd,employeeID from t_user where tName='"+ID+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   if(rs.next()) 
		   {
			  if(rs.getString(1).equals(psw))
				  return rs.getString(2);
				else
					return "error";
		   }
		return "error";
	}
	public static JTable showuser() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"Name","passwd","employeeID","adminID"});
		   String sql="select * from t_user";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
			   String Name=rs.getString(1);
			   String pwd=rs.getString(2);
			   String employeeID=rs.getString(3);
			   String adminID=rs.getString(4);
				model.addRow(new Object[]{Name,pwd,employeeID,adminID});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static void adduser(String s1,String s2,String s3,String s4) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		   String sql="INSERT INTO t_user VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   int rs= psmt.executeUpdate();
		   if(rs!=0) {
			   String sql1="select adminName from t_admin where AdminID='"+s4+"'";
			   PreparedStatement psmt1=conn.prepareStatement(sql1);
			   ResultSet rs1 = psmt1.executeQuery();
			   if(rs1.next()) {
				   Calendar calendar= Calendar.getInstance();
				   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s4+"','"+rs1.getString(1)+"','"
						   +"添加用户"+s1+"',?)";
				   PreparedStatement psmt2=conn.prepareStatement(sql2);
				   psmt2.setString(1,dateFormat.format(calendar.getTime()));
				   psmt2.executeUpdate();
			   }
		   }
	}
	public static boolean employeeexist(String s) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		   String sql="select * from t_user where employeeID = '"+s+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   if(rs.next()) {
			   return false;
		   }
		   return true;
	}
	public static void changeuserpwd(String s1,String s2,String s4) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		   String sql="update t_user set tpasswd = '"+s2+"' where tName = '"+s1+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   int rs= psmt.executeUpdate();
		   if(rs!=0) {
			   String sql1="select adminName from t_admin where AdminID='"+s4+"'";
			   PreparedStatement psmt1=conn.prepareStatement(sql1);
			   ResultSet rs1 = psmt1.executeQuery();
			   if(rs1.next()) {
				   Calendar calendar= Calendar.getInstance();
				   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s4+"','"+rs1.getString(1)+"','"
						   +"更改用户"+s1+"的密码',?)";
				   PreparedStatement psmt2=conn.prepareStatement(sql2);
				   psmt2.setString(1,dateFormat.format(calendar.getTime()));
				   psmt2.executeUpdate();
			   }
		   }
	}
	public static JTable showlogs() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"logID","AdminID","AdminName","content","time"});
		   String sql="select * from t_logs";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
			   int logID=rs.getInt(1);
			   String AdminID=rs.getString(2);
			   String AdminName=rs.getString(3);
			   String content=rs.getString(4);
			   String time=rs.getString(5);
				model.addRow(new Object[]{logID,AdminID,AdminName,content,time});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static void addemployee(String s1,String s2,String s3,String s4,String s5,String s6,String s7
			,String s8,String s9,String s10,String s11,String s12,String s13) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 conn.setAutoCommit(false);//取消自动提交事务
		   String sql="insert into t_employee values('"+s1+"','"+s2+"','"+s3+"',?,?,?,?,?,?,?,?,?,'"+s13+"')";
		   String sql3="insert into t_salary  values( '"+s1+"',3000,0,0,100,3100,100,3000)";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   if(!s4.equals(""))
			   psmt.setString(1,s4);
		   else
			   psmt.setString(1,null);
		   if(!s5.equals(""))
			   psmt.setInt(2, Integer.valueOf(s5));
		   else
			   psmt.setString(2,null);
		   if(!s6.equals(""))
			   psmt.setString(3,s6);
		   else
			   psmt.setString(3,null);
		   if(!s7.equals(""))
			   psmt.setString(4,s7);
		   else
			   psmt.setString(4,null);
		   if(!s8.equals(""))
			   psmt.setString(5,s8);
		   else
			   psmt.setString(5,null);
		   if(!s9.equals(""))
			   psmt.setString(6,s9);
		   else
			   psmt.setString(6,null);
		   if(!s10.equals(""))
			   psmt.setString(7,s10);
		   else
			   psmt.setString(7,null);
		   if(!s11.equals(""))
			   psmt.setString(8,s11);
		   else
			   psmt.setString(8,null);
		   if(!s12.equals(""))
			   psmt.setString(9,s12);
		   else
			   psmt.setString(9,null);
		   int result1= psmt.executeUpdate();
		   PreparedStatement psmt3=conn.prepareStatement(sql3);
		   int result2= psmt3.executeUpdate();
		//   if(rs!=0) {
			   String sql1="select adminName from t_admin where AdminID='"+s13+"'";
			   PreparedStatement psmt1=conn.prepareStatement(sql1);
			   ResultSet rs1 = psmt1.executeQuery();
			   if(rs1.next()) {
				   Calendar calendar= Calendar.getInstance();
				   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s13+"','"+rs1.getString(1)+"','"
						   +"添加职工"+s1+"',?)";
				   String sql5="insert into t_logs(AdminID,adminName,content,time) values('"+s13+"','"+rs1.getString(1)+"','"
						   +"添加职工"+s1+"的工资',?)";
				   PreparedStatement psmt2=conn.prepareStatement(sql2);
				   psmt2.setString(1,dateFormat.format(calendar.getTime()));
				   psmt2.executeUpdate();
				   PreparedStatement psmt5=conn.prepareStatement(sql5);
				   psmt5.setString(1,dateFormat.format(calendar.getTime()));
				   psmt5.executeUpdate();
			   }
		//   }
		   if(result1>0&&result2>0)
			{
				
				conn.commit();//提交事务
				//return 1;
			}
			else
			{
				conn.rollback();//回滚事务
				//return 0;
			}
	}
	public static ArrayList<String> searchemployeebyID(String num1) throws SQLException, ClassNotFoundException{
		 Connection conn=connection();
		 ArrayList<String> list=new ArrayList<String>();
		   String sql="select * from t_employee where employeeID = '"+num1+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   if(rs.next()) {
			   for(int i=2;i<14;i++) {
				   list.add(rs.getString(i));
			   }
		   }
		   return list;
	}
	public static ArrayList<String> searchsalarybyID(String num1) throws SQLException, ClassNotFoundException{
		 Connection conn=connection();
		 ArrayList<String> list=new ArrayList<String>();
		   String sql="select * from t_salary where employeeID = '"+num1+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   if(rs.next()) {
			   for(int i=2;i<9;i++) {
				   list.add(rs.getString(i));
			   }
		   }
		   return list;
	}
	public static void changeemployee(String s1,String s2,String s3,String s4,String s5,String s6,String s7
			,String s8,String s9,String s10,String s11,String s12,String s13) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 String sql="update t_employee set gender=?,age=?,birthday=?,DID=?,DutyID=?,nation=?"
		 		+ ",politicalParty=?,MaritalCon=?,hireDate=? where employeeID='"+s1+"'";
			   PreparedStatement psmt=conn.prepareStatement(sql);
			   if(!s4.equals(""))
				   psmt.setString(1,s4);
			   else
				   psmt.setString(1,null);
			   if(!s5.equals(""))
				   psmt.setInt(2, Integer.valueOf(s5));
			   else
				   psmt.setString(2,null);
			   if(!s6.equals(""))
				   psmt.setString(3,s6);
			   else
				   psmt.setString(3,null);
			   if(!s7.equals(""))
				   psmt.setString(4,s7);
			   else
				   psmt.setString(4,null);
			   if(!s8.equals(""))
				   psmt.setString(5,s8);
			   else
				   psmt.setString(5,null);
			   if(!s9.equals(""))
				   psmt.setString(6,s9);
			   else
				   psmt.setString(6,null);
			   if(!s10.equals(""))
				   psmt.setString(7,s10);
			   else
				   psmt.setString(7,null);
			   if(!s11.equals(""))
				   psmt.setString(8,s11);
			   else
				   psmt.setString(8,null);
			   if(!s12.equals(""))
				   psmt.setString(9,s12);
			   else
				   psmt.setString(9,null);
			   int rs= psmt.executeUpdate();
			   if(rs!=0) {
				   String sql1="select adminName from t_admin where AdminID='"+s13+"'";
				   PreparedStatement psmt1=conn.prepareStatement(sql1);
				   ResultSet rs1 = psmt1.executeQuery();
				   if(rs1.next()) {
					   Calendar calendar= Calendar.getInstance();
					   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s13+"','"+rs1.getString(1)+"','"
							   +"修改职工"+s1+"的信息',?)";
					   PreparedStatement psmt2=conn.prepareStatement(sql2);
					   psmt2.setString(1,dateFormat.format(calendar.getTime()));
					   psmt2.executeUpdate();
				   }
				  }
	}
	public static int deleteuser(String s1,String s2) throws ClassNotFoundException, SQLException {
		Connection conn=connection();
		String sql="delete from t_user where tName = '"+s1+"'";
		PreparedStatement psmt=conn.prepareStatement(sql);
		int rs=psmt.executeUpdate();
		if(rs!=0) {
			 String sql1="select adminName from t_admin where AdminID='"+s2+"'";
			   PreparedStatement psmt1=conn.prepareStatement(sql1);
			   ResultSet rs1 = psmt1.executeQuery();
			   if(rs1.next()) {
				   Calendar calendar= Calendar.getInstance();
				   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s2+"','"+rs1.getString(1)+"','"
						   +"删除用户"+s1+"',?)";
				   PreparedStatement psmt2=conn.prepareStatement(sql2);
				   psmt2.setString(1,dateFormat.format(calendar.getTime()));
				   psmt2.executeUpdate();
			   }
			   return 1;
		}
		return 0;
	}
	public static int deleteemployee(String s1,String s2) throws ClassNotFoundException, SQLException {
//		Connection conn=connection();
//		conn.setAutoCommit(false);//取消自动提交事务
//		String sql1="delete from t_salary where employeeID = '"+s1+"'";
//		String sql2="delete from t_employee where employeeID = '"+s1+"'";
//		String sql5="select adminName from t_admin where AdminID='"+s2+"'";
//		PreparedStatement psmt4=conn.prepareStatement(sql1);
//		int result1=psmt4.executeUpdate();
//		PreparedStatement psmt5=conn.prepareStatement(sql2);
//		   int result2=psmt5.executeUpdate();
//	    PreparedStatement psmt1=conn.prepareStatement(sql5);
//		   ResultSet rs1 = psmt1.executeQuery();
//		   if(rs1.next()) {
//			   Calendar calendar= Calendar.getInstance();
//			   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
//		String sql3="insert into t_logs(AdminID,adminName,content,time) values('"+s2+"','"+rs1.getString(1)+"','"
//				   +"删除职工"+s1+"',?)";
//	    String sql4="insert into t_logs(AdminID,adminName,content,time) values('"+s2+"','"+rs1.getString(1)+"','"
//				   +"删除职工"+s1+"的工资',?)";
//			   PreparedStatement psmt2=conn.prepareStatement(sql3);
//			   PreparedStatement psmt3=conn.prepareStatement(sql4);
//			   psmt2.setString(1,dateFormat.format(calendar.getTime()));
//			   psmt3.setString(1,dateFormat.format(calendar.getTime()));
//			   psmt2.executeUpdate();
//			   psmt3.executeUpdate();
//		   }
//		   if(result1>0&&result2>0)
//			{
//				
//				conn.commit();//提交事务
//				return 1;
//			}
//			else
//			{
//				conn.rollback();//回滚事务
//				return 0;
//			}
		Connection conn=connection();
		String sql="delete from t_employee where employeeID = '"+s1+"'";
		PreparedStatement psmt=conn.prepareStatement(sql);
		int rs=psmt.executeUpdate();
		if(rs!=0) {
			 String sql1="select adminName from t_admin where AdminID='"+s2+"'";
			   PreparedStatement psmt1=conn.prepareStatement(sql1);
			   ResultSet rs1 = psmt1.executeQuery();
			   if(rs1.next()) {
				   Calendar calendar= Calendar.getInstance();
				   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s2+"','"+rs1.getString(1)+"','"
						   +"删除职工"+s1+"',?)";
				   PreparedStatement psmt2=conn.prepareStatement(sql2);
				   psmt2.setString(1,dateFormat.format(calendar.getTime()));
				   psmt2.executeUpdate();
			   }
			   return 1;
		}
		return 0;
	}
	public static JTable showfamily() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"memID","employeeID","memName","memGender","memBirthday","memRelation","memTel"});
		   String sql="select * from t_familymem";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable selectuserfamily(String s) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"序号","employeeID","memName","memGender","memBirthday","memRelation","memTel"});
		   String sql="select * from t_familymem where employeeID='"+s+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   int i=1;
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{i,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
		        i++;
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showemployee() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"employeeID","name","idCard","gender","age",
				 "birthday","DID","DutyID","nation","politicalParty","MaritalCon","hireDate","RecordID"});
		   String sql="select * from t_employee";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable selectuserexp(String s) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"序号","employeeID","Starttime","Endtime",
				 "CompanyOrSchool","Tduty","education"});
		   String sql="select * from t_workexp where employeeID='"+s+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   int i=1;
		   while(rs.next()) 
		   {
			   	model.addRow(new Object[]{i,rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7)});
				i++;
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showexp() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"ExpID","employeeID","Starttime","Endtime",
				 "CompanyOrSchool","Tduty","education"});
		   String sql="select * from t_workexp";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	
	public static JTable showcourse() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"课程ID","课程名","学时数"});
		   String sql="select * from t_course";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showchoosecourse() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"职工号","课程号","成绩"});
		   String sql="select * from t_choosecourse";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable selectuserchoosecourse(String s1) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"职工号","课程号","成绩"});
		   String sql="select * from t_choosecourse where employeeID='"+s1+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showevaluate() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"年份","月份","职工号","工作难度系数","工作量记录",
				 "工作评价"});
		   String sql="select * from t_evaluation";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable selectevaluate(String s1) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"序号","年份","月份","职工号","工作难度系数","工作量记录",
				 "工作评价"});
		   String sql="select * from t_evaluation where employeeID='"+s1+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   int i=1;
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{i,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6)});
				i++;
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showrecord() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"年份","月份","职工号","部门号","全勤日数",
				 "请假天数","矿工天数","出差天数","迟到次数","早退次数","加班天数"});
		   String sql="select * from t_workRecord";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable selectuserrecord(String s1) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"序号","年份","月份","职工号","部门号","全勤日数",
				 "请假天数","矿工天数","出差天数","迟到次数","早退次数","加班天数"});
		   String sql="select * from t_workRecord where employeeID='"+s1+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   int i=1;
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{i,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11)});
				i++;
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showsalary() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"职工号","基本工资","岗位津贴","奖励","养老金",
				 "应发工资","税收","实发工资"});
		   String sql="select * from t_salary";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable selectusersalary(String s1) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"职工号","基本工资","岗位津贴","奖励","养老金",
				 "应发工资","税收","实发工资"});
		   String sql="select * from t_salary where employeeID='"+s1+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showduty() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"职务号","职务名称"});
		   String sql="select * from t_duty";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable showdepartment() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"部门号","部门名称","部门人数"});
		   String sql="select * from t_department";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable searchone(String s2) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"职工号","姓名","职称"});
		   String sql="select employeeID, name, DutyName from t_employee,t_department,t_duty where t_department.DID"
		   		+ "=t_employee.DID and t_duty.DutyID=t_employee.DutyID and DNAME = '"+s2+"'";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable searchtwo() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"部门号","平均工资"});
		   String sql="select DID, avg(realwage) from t_employee,t_salary where t_employee.employeeID"
		   		+ "=t_salary.employeeID group by DID";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable searchthree() throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"员工号","员工姓名"});
		   String sql="select employeeID, name from t_employee where not exists ( select "
		   		+ "* from t_course where not exists (select * from t_choosecourse where "
		   		+ "t_choosecourse.CID=t_course.CID and t_employee.employeeID = t_choosecourse.employeeID))";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable searchfour(String s1,String s2) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"员工号","员工姓名","平均成绩"});
		   String sql="select t_employee.employeeID ,name , avg(grades) from t_employee,t_choosecourse "
		   		+ "where t_employee.employeeID=t_choosecourse.employeeID group by t_choosecourse.employeeID "
		   		+ "having count(CID) > "+(Integer.valueOf(s1)-1)+" and avg(grades) > "+Double.valueOf(s2);
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable searchfive(String s1) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"员工号","平均成绩"});
		   String sql="select * from employeeavggrade where avggrades >  "+ Double.valueOf(s1);
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static JTable gradeorder(String s1) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 DefaultTableModel model=new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"排名","员工号","平均成绩"});
		   String sql="select * from employeeavggrade where avggrades >  (select avggrades from "
		   		+ "employeeavggrade where employeeID='"+ s1+"') order by avggrades desc";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   ResultSet rs = psmt.executeQuery();
		   int i=1;
		   while(rs.next()) 
		   {
				model.addRow(new Object[]{i,rs.getString(1),rs.getString(2)});
				i++;
		   }
		   JTable table=new JTable(model);
		   return table;
	}
	public static void adddepartment(String s1,String s2,String s3) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		   String sql="insert into t_department values('"+s1+"','"+s2+"',0)";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   int rs=psmt.executeUpdate();
		   if(rs!=0) {
				 String sql1="select adminName from t_admin where AdminID='"+s3+"'";
				   PreparedStatement psmt1=conn.prepareStatement(sql1);
				   ResultSet rs1 = psmt1.executeQuery();
				   if(rs1.next()) {
					   Calendar calendar= Calendar.getInstance();
					   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s3+"','"+rs1.getString(1)+"','"
							   +"新增了部门"+s2+"',?)";
					   PreparedStatement psmt2=conn.prepareStatement(sql2);
					   psmt2.setString(1,dateFormat.format(calendar.getTime()));
					   psmt2.executeUpdate();
				   }
			}
	}
	public static void changesalary(String s1,String s2,String s3,String s4,String s5,String s6,String s7) throws ClassNotFoundException, SQLException {
		 Connection conn=connection();
		 double sum=Double.valueOf(s2);
		 double sum1=0;
		   String sql="update t_salary set basicwage=?,allowance=?,award=?,pension=?,payable=?" + 
		   		",taxes=?,realwage=? where employeeID= ?";
		   PreparedStatement psmt=conn.prepareStatement(sql);
		   psmt.setString(8,s1);
		   psmt.setDouble(1, Double.valueOf(s2));
		   if(!s3.equals("")) {
		   psmt.setDouble(2, Double.valueOf(s3));
		   sum=sum+Double.valueOf(s3);
		   }
		   else
			   psmt.setString(2,null);
		   if(!s4.equals("")) {
			   psmt.setDouble(3, Double.valueOf(s4));
			  sum=sum+Double.valueOf(s4);
		   }
			   else
				   psmt.setString(3,null);
		   if(!s5.equals("")) {
			   psmt.setDouble(4, Double.valueOf(s5));
			   sum=sum+Double.valueOf(s5);
		   }
			   else
				   psmt.setString(4,null);
		   psmt.setDouble(5, sum);
		   if(!s6.equals("")) {
			   psmt.setDouble(6, Double.valueOf(s6));
			   sum1=sum-Double.valueOf(s6);
		   }
			   else {
				   psmt.setString(6,null);
				   sum1=sum;
			   }
		   psmt.setDouble(7, sum1);
		   int rs=psmt.executeUpdate();
		   if(rs!=0) {
				 String sql1="select adminName from t_admin where AdminID='"+s7+"'";
				   PreparedStatement psmt1=conn.prepareStatement(sql1);
				   ResultSet rs1 = psmt1.executeQuery();
				   if(rs1.next()) {
					   Calendar calendar= Calendar.getInstance();
					   SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					   String sql2="insert into t_logs(AdminID,adminName,content,time) values('"+s7+"','"+rs1.getString(1)+"','"
							   +"修改了职员"+s1+"的工资信息',?)";
					   PreparedStatement psmt2=conn.prepareStatement(sql2);
					   psmt2.setString(1,dateFormat.format(calendar.getTime()));
					   psmt2.executeUpdate();
				   }
			}
	}
}
