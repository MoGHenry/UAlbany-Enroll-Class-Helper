import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datatype.ClassDatatype;

public class Connecter {

	//Properties
	final String url="jdbc:mysql://rm-7go3u68vd3t64pgv11o.mysql.rds.aliyuncs.com:3306/test1";
	final String username="user0";
	final String password="Huang36963";
	Connection con;
	Statement statement;
	ResultSet rs;
	int insertSuccess;
	int insertFail;
	
	//Constructor
	public Connecter() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("load driver success");
	}
	catch(Exception e) {
		System.out.println("load driver fall");
	}
	try {
		con=DriverManager.getConnection(url,username,password);
		if(!con.isClosed())
			System.out.println("access database success");
		statement=con.createStatement();
	}
	catch(Exception e) {
		System.out.println("get wrong information");
	}
}

//insert course into database
public void sent (ClassDatatype course) throws SQLException {
	//int testpoint=0;
	
	//course info
	String courseSubject=null;
	String catalogNumber=null;
	String courseName=null;
	String classNumber=course.getClassNumber();
	String department=null;
	String level=null;
	String meetingTime=null;
	String meetingLocation=null;
	String preRequest=null;
	String labRequest=null;
	String component=null;
	String creditRange=null;
	String session=null;
	String courseDelivery=null;
	String genED=null;
	String seatsRemain=null;
	String specialRestriction=null;
	String description=null;
	
	
	
	try {
	//check if the course exist in database	
	String sql="SELECT classNumber FROM courses WHERE classNumber='"+classNumber+"';";
	rs=statement.executeQuery(sql);
	if(rs.next()) {
		//if exist, update it
		System.out.println("course exist, will update");
	    sql="SELECT classNumber FROM seatsremain WHERE classNumber='"+classNumber+"';";
		rs=statement.executeQuery(sql);
		seatsRemain = course.getSeatsRemainingAsOfLastUpdate();
		specialRestriction=course.getSpecialRestriction();
		seatsRemain=specialCharTreat(seatsRemain);
		specialRestriction=specialCharTreat(specialRestriction);
		if(specialRestriction.equalsIgnoreCase("none"))
		 specialRestriction = null;
		if(rs.next())
			sql="UPDATE seatsremain set seatsRemain='"+seatsRemain+"',specialRestriction='"+specialRestriction+"' WHERE classNumber='"+classNumber+"';";
		else 
			 sql="INSERT INTO seatsremain VALUES ('"+classNumber+"','"+seatsRemain+"','"+specialRestriction+"');";
		statement.executeUpdate(sql);
		return;
	}

	
	
	//import and construct all course info
	String temporary=course.getCourseInfo();
	int index=temporary.indexOf(" ");
	courseSubject = temporary.substring(0, index);//1
	temporary=temporary.substring(index+1);
	index=temporary.indexOf(" ");
	catalogNumber = temporary.substring(0,index);//2
	courseName = temporary.substring(index+1);//3
	
	classNumber = course.getClassNumber();//4
	
	department = course.getDepartmentOrProgram();//5
	
	level = course.getLevel();//6
	
	temporary=course.getMeetingInfo();
	index=temporary.lastIndexOf("AM");
	int index2=temporary.lastIndexOf("PM");
	index=Math.max(index, index2);
	meetingTime = temporary.substring(0,index+2);//7
	meetingLocation = temporary.substring(index+3);//8
	
	preRequest = course.getComments();//9
	if(preRequest=="")
		preRequest=null;
	temporary=course.getComments();
	if(temporary.toLowerCase().indexOf("first register for")>=0)
	 labRequest = "yes";//10
	else labRequest="no";
	
	component=course.getComponentIsBlankIfLecture();//11
	if(component=="")
	 component = null;
	
	creditRange = course.getCreditRange();//12
	
	session = course.getSession();//13
	
	courseDelivery = course.getCourseDeliveryMethod();//14
	
	genED=course.getGeneralEducationCourse();//15
	if(genED.equalsIgnoreCase("none"))
	 genED = null;
	
	seatsRemain = course.getSeatsRemainingAsOfLastUpdate();//16
	
	specialRestriction=course.getSpecialRestriction();//17
	if(specialRestriction.equalsIgnoreCase("none"))
	 specialRestriction = null;
	
	description = course.getCourseDescription();//18
	
	
	
	//sql special characters treatment
	courseSubject=specialCharTreat(courseSubject);
	catalogNumber=specialCharTreat(catalogNumber);
	courseName=specialCharTreat(courseName);
	classNumber=specialCharTreat(classNumber);
	department=specialCharTreat(department);
	level=specialCharTreat(level);
	meetingTime=specialCharTreat(meetingTime);
	meetingLocation=specialCharTreat(meetingLocation);
	preRequest=specialCharTreat(preRequest);
	labRequest=specialCharTreat(labRequest);
	component=specialCharTreat(component);
	creditRange=specialCharTreat(creditRange);
	session=specialCharTreat(session);
	courseDelivery=specialCharTreat(courseDelivery);
	genED=specialCharTreat(genED);
	seatsRemain=specialCharTreat(seatsRemain);
	specialRestriction=specialCharTreat(specialRestriction);
	description=specialCharTreat(description);

	
	
	//insert course into database
	sql="INSERT INTO courses VALUES ('"+courseSubject+"','"+catalogNumber+"','"+classNumber+"','"+courseName+"','"+department
			+"','"+level+"','"+meetingTime+"','"+meetingLocation+"','"+preRequest+"','"+labRequest
			+"','"+component+"','"+creditRange+"','"+session+"','"+courseDelivery+"','"+genED+"');";
	statement.executeUpdate(sql);
	//testpoint=1;
	 sql="INSERT INTO seatsremain VALUES ('"+classNumber+"','"+seatsRemain+"','"+specialRestriction+"');";
	statement.executeUpdate(sql);
	//testpoint=2;
	sql="INSERT INTO coursedescription VALUES ('"+classNumber+"','"+description+"');";
	statement.executeUpdate(sql);

	insertSuccess++;
	System.out.println("insertion success");
	}
	catch(Exception e) {
		insertFail++;
		System.out.println("insertion fail");
		//System.out.println(testpoint);
	}
}




public String specialCharTreat(String a) {
	if(a!=null) {
	a=a.replace("'","''");
	a=a.replace("*","");
	return a;
	}
	else return a;
}




public void cleanDatabase() throws SQLException {
	String sql="DELETE FROM `seatsremain`;";
	statement.executeUpdate(sql);
	 sql="DELETE FROM `coursedescription`;";
	statement.executeUpdate(sql);	
	sql="DELETE FROM `courses`;";
	statement.executeUpdate(sql);	
}




public void showDatabase() throws SQLException {
	System.out.println("\n\n\n\n");
	String sql="SELECT * FROM courses";
	rs=statement.executeQuery(sql);
	while(rs.next()) {
	System.out.print(rs.getString("courseSubject")+"\t");
	System.out.print(rs.getString("catalogNumber")+"\t");
	System.out.print(rs.getInt("classNumber")+"\t");
	System.out.print(rs.getString("courseName")+"\t");
	System.out.print(rs.getString("department")+"\t");
	System.out.print(rs.getString("level")+"\t");
	System.out.print(rs.getString("meetingTime")+"\t");
	System.out.print(rs.getString("meetingLocation")+"\t");
	System.out.print(rs.getString("preRequest")+"\t");
	System.out.print(rs.getString("labRequest")+"\t");
	System.out.print(rs.getString("component")+"\t");
	System.out.print(rs.getString("creditRange")+"\t");
	System.out.print(rs.getString("session")+"\t");
	System.out.print(rs.getString("courseDelivery")+"\t");
	System.out.println(rs.getString("genED")+"\t");
	}
	
	System.out.println("\n\n\n\n");
	sql="SELECT * FROM coursedescription";
	rs=statement.executeQuery(sql);
	while(rs.next()) {
	System.out.print(rs.getInt("classNumber")+"\t");
	System.out.print(rs.getString("description")+"\t");
	}	
	
	System.out.println("\n\n\n\n");
    sql="SELECT * FROM seatsremain";
	rs=statement.executeQuery(sql);
	while(rs.next()) {
	System.out.print(rs.getInt("classNumber")+"\t");
	System.out.print(rs.getInt("seatsRemain")+"\t");
	System.out.println(rs.getString("specialRestriction")+"\t");
	}
}




public void closeConnecter() throws SQLException {
	if(statement!=null)
	statement.close();
	if(con!=null)
	con.close();
	if(rs!=null)
	rs.close();
	System.out.println("There are "+insertSuccess+"courses insert successly and "+insertFail+"courses insertion fail.");
}
}





//test use code storage here
/*

	System.out.println(courseSubject);
	System.out.println(catalogNumber);
	System.out.println(courseName);
	System.out.println(classNumber);
	System.out.println(department);
	System.out.println(level);
	System.out.println(meetingTime);
	System.out.println(meetingLocation);
	System.out.println(preRequest);
	System.out.println(labRequest);
	System.out.println(component);
	System.out.println(creditRange);
	System.out.println(session);
	System.out.println(courseDelivery);
	System.out.println(genED);
	System.out.println(seatsRemain);
	System.out.println(specialRestriction);
	System.out.println(description);
*/
