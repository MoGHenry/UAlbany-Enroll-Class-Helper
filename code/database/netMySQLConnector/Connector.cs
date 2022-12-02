using System;
using System.Xml.Linq;
using MySql.Data.MySqlClient;
using MySqlX.XDevAPI.Relational;


namespace Connector
{
    class Connector
    {
        //properties
        MySql.Data.MySqlClient.MySqlConnection conn;
        string myConnectionString= "server=rm-7go3u68vd3t64pgv11o.mysql.rds.aliyuncs.com;uid=user0;" +
                "pwd=Huang36963;port=3306;database=test1";


        //Constructor
        public Connector() {
            try
            {
                conn = new MySql.Data.MySqlClient.MySqlConnection();
                conn.ConnectionString = myConnectionString;
                conn.Open();
                Console.WriteLine("Connected to database");
            }
            catch (MySqlException e) {
                Console.WriteLine("Connection Process Fail");
            }
        }


        //Search courses with subject name method
        public ClassDataType[] searchWithSubject(String subject) {
            string mycmd = "SELECT COUNT(*) FROM (`courses` INNER JOIN `seatsremain`ON courses.classNumber=seatsremain.classNumber) INNER JOIN `coursedescription` ON courses.classNumber=coursedescription.classNumber ";
            //(`courses` INNER JOIN `seatsremain` ON courses.classNumber = seatsremain.classNumber)
            //INNER JOIN `coursedescription` ON courses.classNumber = coursedescription.classNumber
             mycmd += "WHERE courses.`courseSubject` = '" + subject+ "';";
            MySqlCommand cmd = new MySqlCommand(mycmd,conn);
           // Console.WriteLine("good here");
           // MySqlDataReader reader = cmd.ExecuteReader();
            int row = Int32.Parse(cmd.ExecuteScalar().ToString());
            Console.WriteLine("there are "+row);
            if (row == 0)
                return null;
            ClassDataType[] searchResult=new ClassDataType[row];
          //  string column="level, department, classNumber, courseSubject, catalogNumber, courseName";
            mycmd= "SELECT * FROM (`courses` INNER JOIN `seatsremain`ON courses.classNumber=seatsremain.classNumber) INNER JOIN `coursedescription` ON courses.classNumber=coursedescription.classNumber ";
            mycmd += "WHERE courses.`courseSubject` = '" + subject + "';";
            cmd = new MySqlCommand(mycmd,conn);
            MySqlDataReader reader = cmd.ExecuteReader();
            searchResult = formCourseList(reader, row);
            reader.Close();
            return searchResult;
        }


        //Search courses with course title method
        public ClassDataType[] searchWithTitle(String title)
        {
            int index = title.IndexOfAny("0123456789".ToCharArray());
            string courseSubject=title.Substring(0, index);
            string catalogNumber=title.Substring(index);

            string mycmd = "SELECT COUNT(*) FROM (`courses` INNER JOIN `seatsremain`ON courses.classNumber=seatsremain.classNumber) INNER JOIN `coursedescription` ON courses.classNumber=coursedescription.classNumber ";
            mycmd += "WHERE courses.`courseSubject` = '" + courseSubject + "'";
            mycmd += "AND courses.`catalogNumber` = '" + catalogNumber + "';";
            MySqlCommand cmd = new MySqlCommand(mycmd, conn);
            // Console.WriteLine("good here");
            // MySqlDataReader reader = cmd.ExecuteReader();
            int row = Int32.Parse(cmd.ExecuteScalar().ToString());
            Console.WriteLine("there are " + row);
            if (row == 0)
                return null;
            ClassDataType[] searchResult = new ClassDataType[row];
            //  string column="level, department, classNumber, courseSubject, catalogNumber, courseName";
            mycmd = "SELECT * FROM (`courses` INNER JOIN `seatsremain`ON courses.classNumber=seatsremain.classNumber) INNER JOIN `coursedescription` ON courses.classNumber=coursedescription.classNumber ";
            mycmd += "WHERE courses.`courseSubject` = '" + courseSubject + "' ";
            mycmd += "AND courses.`catalogNumber` = '" + catalogNumber + "';";
            cmd = new MySqlCommand(mycmd, conn);
            MySqlDataReader reader = cmd.ExecuteReader();
            searchResult = formCourseList(reader, row);
            reader.Close();
            return searchResult;
        }


        //release resources method
        public void close() { 
        conn.Close();
        }


        //constructure course array method
        private ClassDataType[] formCourseList(MySqlDataReader reader, int row) {
            int count = 0;
            ClassDataType[] searchResult = new ClassDataType[row];
            while (reader.Read())
            {
                string level = reader.GetString("level");
            string department = reader.GetString("department");
            int classNumber = reader.GetInt32("classNumber");
            string courseInfo = reader.GetString("courseSubject") + " " + reader.GetString("catalogNumber") + " " + reader.GetString("courseName");
            string meetingTime = reader.GetString("meetingTime");
            string meetingLocation = reader.GetString("meetingLocation");
            string prerequest = reader.GetString("preRequest");
            string labrequest = reader.GetString("labRequest");
            string creditRange = reader.GetString("creditRange");
            string classType = reader.GetString("component");
            int seatsRemain = reader.GetInt32("seatsRemain");
            string session = reader.GetString("session");
            string courseDelivery = reader.GetString("courseDelivery");
            string genEd = reader.GetString("genED");
            string specialRestriction = reader.GetString("specialRestriction");
            string description = reader.GetString("Description");

            ClassDataType course = new ClassDataType();
            course.level = level;
            course.department = department;
            course.classNumber = classNumber;
            course.courseInfo = courseInfo;
            course.meetingTime = meetingTime;
            course.meetingLocation = meetingLocation;
            course.prerequest = prerequest;
            course.labrequest = labrequest;
            course.creditRange = creditRange;
            course.classType = classType;
            course.seatsRemain = seatsRemain;
            course.session = session;
            course.courseDelivery = courseDelivery;
            course.genEd = genEd;
            course.specialRestriction = specialRestriction;
            course.description = description;
                searchResult[count]=course;
                count++;
            }
            reader.Close();
            return searchResult;
        }

        public ClassDataType[] ICSIfreshman() {

            string mycmd = "SELECT COUNT(*) FROM (`courses` INNER JOIN `seatsremain`ON courses.classNumber=seatsremain.classNumber) INNER JOIN `coursedescription` ON courses.classNumber=coursedescription.classNumber ";
            //(`courses` INNER JOIN `seatsremain` ON courses.classNumber = seatsremain.classNumber)
            //INNER JOIN `coursedescription` ON courses.classNumber = coursedescription.classNumber
            mycmd += "WHERE (courses.`courseSubject` = 'ICSI' AND courses.`catalogNumber` = '201' AND courses.`component`  =' ') ";
            mycmd += "OR (courses.`courseSubject` = 'ICSI' AND courses. `catalogNumber`= '210' AND courses.`component`  =' ') ";
            mycmd += "OR (courses.`courseSubject` = 'ICSI' AND courses. `catalogNumber`= '418Y' AND courses.`component`  =' ');";
            MySqlCommand cmd = new MySqlCommand(mycmd, conn);
            // Console.WriteLine("good here");
            // MySqlDataReader reader = cmd.ExecuteReader();
            int row = Int32.Parse(cmd.ExecuteScalar().ToString());
            Console.WriteLine("there are " + row);
            if (row == 0)
                return null;
            ClassDataType[] searchResult = new ClassDataType[row];
            //  string column="level, department, classNumber, courseSubject, catalogNumber, courseName";
            mycmd = "SELECT * FROM (`courses` INNER JOIN `seatsremain`ON courses.classNumber=seatsremain.classNumber) INNER JOIN `coursedescription` ON courses.classNumber=coursedescription.classNumber ";
            mycmd += "WHERE (courses.`courseSubject` = 'ICSI' AND courses.`catalogNumber` = '201' AND courses.`component` =' ') ";
            mycmd += "OR (courses.`courseSubject` = 'ICSI' AND courses. `catalogNumber`= '210' AND courses.`component`  =' ') ";
            mycmd += "OR (courses.`courseSubject` = 'ICSI' AND courses. `catalogNumber` LIKE '418%' AND courses.`component`  =' ');";
            cmd = new MySqlCommand(mycmd, conn);
            MySqlDataReader reader = cmd.ExecuteReader();
            searchResult = formCourseList(reader, row);
            reader.Close();
            return searchResult;
        }
    }
}
