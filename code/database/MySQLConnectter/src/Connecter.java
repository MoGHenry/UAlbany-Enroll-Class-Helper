import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import datatype.ClassDatatype;

public class Connecter {

	final String url="jdbc:mysql://rm-7go3u68vd3t64pgv11o.mysql.rds.aliyuncs.com:3306/test1";
	final String username="user0";
	final String password="Huang36963";
	Connection con=null;
	Statement statement=null;
	ResultSet rs=null;
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


public void sent (ClassDatatype course) throws SQLException {
	try {
	String temporary=course.getCourseInfo();
	int index=temporary.indexOf(" ");
	String courseSubject = temporary.substring(0, index);//1
	temporary=temporary.substring(index+1);
	index=temporary.indexOf(" ");
	String catalogNumber = temporary.substring(0,index);//2
	String courseName = temporary.substring(index+1);//3
	String classNumber = course.getClassNumber();//4
	String department = course.getDepartmentOrProgram();//5
	String level = course.getLevel();//6
	temporary=course.getMeetingInfo();
	index=temporary.lastIndexOf("AM");
	int index2=temporary.lastIndexOf("PM");
	index=Math.max(index, index2);
	String meetingTime = temporary.substring(0,index+2);//7
	String meetingLocation = temporary.substring(index+3);//8
	String preRequest = course.getComments();//9
	temporary=course.getComments();
	System.out.println("check point 3");
	String labRequest;//10
	if(temporary.indexOf("Register for a Disc")>=0)
	 labRequest = "discussion";
	else if(temporary.indexOf("FIRST register for a Lab")>=0)
		labRequest="lab";
	else labRequest=null;
	System.out.println("check point 4");
	temporary=course.getComponentIsBlankIfLecture();
	String component=course.getComponentIsBlankIfLecture();//11
	if(temporary.equalsIgnoreCase(""))
	 component = null;
	String creditRange = course.getCreditRange();//12
	String session = course.getSession();//13
	String courseDelivery = course.getCourseDeliveryMethod();//14
	String genED=course.getGeneralEducationCourse();//15
	temporary=course.getGeneralEducationCourse();
	if(temporary.equalsIgnoreCase("none"))
	 genED = null;
	String seatsRemain = course.getSeatsRemainingAsOfLastUpdate();//16
	String specialRestriction=course.getSpecialRestriction();//17
	temporary=course.getSpecialRestriction();
	if(temporary.equalsIgnoreCase("none"))
	 specialRestriction = null;
	String description = course.getCourseDescription();//18
	String other = course.getOther();//19
	
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
	System.out.println(other);
	*/
			
	String sql="INSERT INTO courses VALUES ('"+courseSubject+"','"+catalogNumber+"','"+classNumber+"','"+courseName+"','"+department
			+"','"+level+"','"+meetingTime+"','"+meetingLocation+"','"+preRequest+"','"+labRequest
			+"','"+component+"','"+creditRange+"','"+session+"','"+courseDelivery+"','"+genED+"');";
	statement.executeUpdate(sql);
	
	 sql="INSERT INTO seatsremain VALUES ('"+classNumber+"','"+seatsRemain+"','"+specialRestriction+"');";
	statement.executeUpdate(sql);
	
	sql="INSERT INTO coursedescription VALUES ('"+classNumber+"','"+description+"','"+other+"');";
	statement.executeUpdate(sql);
	
	System.out.println("insertion success");
	}
	catch(SQLException e) {
		System.out.println("insertion fail");
	}
	
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
	System.out.println(rs.getString("other")+"\t");
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
	statement.close();
	con.close();
	rs.close();
}
}