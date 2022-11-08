import java.sql.SQLException;

import datatype.ClassDatatype;

public class Tester {
	public static void main(String[]args) throws SQLException {
Connecter mydatabase=new Connecter();
mydatabase.showDatabase();
ClassDatatype test=new ClassDatatype();

test.setLevel("Undergraduate");
test.setDepartmentOrProgram("Africana Studies");
test.setClassNumber("6667");
test.setCourseInfo("AAFS 209 Black American Music");
test.setMeetingInfo("MW 11:40_AM-01:00_PM Lecture Center 12 Gaunt,Kyra");
test.setComments("Cross listed with AMUS 209");
test.setCreditRange("3.0- 3.0");
test.setComponentIsBlankIfLecture("");
test.setSeatsRemainingAsOfLastUpdate("0");
test.setSession("FULL");
test.setCourseDeliveryMethod("INPERSON");
test.setGeneralEducationCourse("DP-ARTS");
test.setSpecialRestriction("None");
test.setCourseDescription("An introduction to Black American Music. Study will "
		+ "include music from West Africa as well as musical/social influences "
		+ "throughout American history. Musical styles will include spirituals, "
		+ "gospel, blues, jazz and classical.");
test.setOther("College or School: *College of Arts and Sciences*\r\n"
		+ "Department or Program: *Africana Studies*\r\n"
		+ "Topic if applicable: **\r\n"
		+ "IT Commons: *N*\r\n"
		+ "Honors College Course: *N*\r\n"
		+ "Writing Intensive: *N*\r\n"
		+ "Oral Discourse: *N*\r\n"
		+ "Info Literacy: *N*\r\n"
		+ "COIL - Collaborative Online International Learning: *NONE*\r\n"
		+ "OER - Open Educational Resources: *NONE*");

//mydatabase.sent(test);
}
}