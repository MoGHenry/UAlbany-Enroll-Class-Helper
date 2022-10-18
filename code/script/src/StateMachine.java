import datatype.ClassDatatype;

public class StateMachine {
    public StateMachine() {
    }

    public int GetState(int state, String input, ClassDatatype classDatatype){
        if(state == 0){

            if(input.length() < 2){
                return 0;
            }

            if(input.substring(0,1).equalsIgnoreCase("-")){
                return 1;
            }else{
                return 0;
            }

        }else if(state == 1){

            classDatatype = new ClassDatatype();
            return 2;

        }else if(state == 2){

            if(input.substring(0,1).equalsIgnoreCase("-")){
                return 1;
            }

            String[] spiltTital = input.split(":");
            String[] split = new String[2];
            split[0] = spiltTital[0];
            split[1] = spiltTital[1];
            if(spiltTital.length > 2){
                for (int i = 2; i < spiltTital.length; i++) {
                    split[1] = split[1] + ":" + spiltTital[i];
                }
            }

            if(split[0].equalsIgnoreCase("Level")){
                return GetState(3,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Department or Program")){
                return GetState(4,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Class Number")){
                return GetState(5,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Course Info")){
                return GetState(6,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Meeting Info")){
                return GetState(7,input.substring(13),classDatatype);
            }else if(split[0].equalsIgnoreCase("Comments")){
                return GetState(8,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Credit Range")){
                return GetState(9,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Component is blank if lecture")){
                return GetState(10,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Seats remaining as of last update")){
                return GetState(11,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Session")){
                return GetState(12,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Course Delivery Method")){
                return GetState(13,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("General Education Course")){
                return GetState(14,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Special Restriction")){
                return GetState(15,split[1],classDatatype);
            }else if(split[0].equalsIgnoreCase("Course Description")){
                return GetState(16,split[1],classDatatype);
            }else{
                return GetState(17,input,classDatatype);
            }


        }else if(state == 3){ //Level
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setLevel(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setLevel(classDatatype.getLevel() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setLevel(classDatatype.getLevel() + input);
                return 3;
            }

        }else if(state == 4){ //Department or Program
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setDepartmentOrProgram(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setDepartmentOrProgram(classDatatype.getDepartmentOrProgram() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setDepartmentOrProgram(classDatatype.getDepartmentOrProgram() + input);
                return 4;
            }

        }else if(state == 5){ //Class Number
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setClassNumber(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setClassNumber(classDatatype.getClassNumber() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setClassNumber(classDatatype.getClassNumber() + input);
                return 5;
            }

        }else if(state == 6){ //Course Info
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setCourseInfo(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setCourseInfo(classDatatype.getCourseInfo() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setCourseInfo(classDatatype.getCourseInfo() + input);
                return 6;
            }

        }else if(state == 7){ //Meeting Info
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setMeetingInfo(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setMeetingInfo(classDatatype.getMeetingInfo() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setMeetingInfo(classDatatype.getMeetingInfo() + input);
                return 7;
            }

        }else if(state == 8){ //Comments
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setComments(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setComments(classDatatype.getComments() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setComments(classDatatype.getComments() + input);
                return 8;
            }

        }else if(state == 9){ //Credit Range
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setCreditRange(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setCreditRange(classDatatype.getCreditRange() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setCreditRange(classDatatype.getCreditRange() + input);
                return 9;
            }

        }else if(state == 10){ //Component is blank if lecture
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setComponentIsBlankIfLecture(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setComponentIsBlankIfLecture(classDatatype.getComponentIsBlankIfLecture() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setComponentIsBlankIfLecture(classDatatype.getComponentIsBlankIfLecture() + input);
                return 10;
            }

        }else if(state == 11){ //Seats remaining as of last update
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setSeatsRemainingAsOfLastUpdate(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setSeatsRemainingAsOfLastUpdate(classDatatype.getSeatsRemainingAsOfLastUpdate() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setSeatsRemainingAsOfLastUpdate(classDatatype.getSeatsRemainingAsOfLastUpdate() + input);
                return 11;
            }

        }else if(state == 12){ //Session
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setSession(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setSession(classDatatype.getSession() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setSession(classDatatype.getSession() + input);
                return 12;
            }

        }else if(state == 13){ //Course Delivery Method
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setCourseDeliveryMethod(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setCourseDeliveryMethod(classDatatype.getCourseDeliveryMethod() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setCourseDeliveryMethod(classDatatype.getCourseDeliveryMethod() + input);
                return 13;
            }

        }else if(state == 14){ //General Education Course
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setGeneralEducationCourse(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setGeneralEducationCourse(classDatatype.getGeneralEducationCourse() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setGeneralEducationCourse(classDatatype.getGeneralEducationCourse() + input);
                return 14;
            }

        }else if(state == 15){ //Special Restriction
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setSpecialRestriction(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setSpecialRestriction(classDatatype.getSpecialRestriction() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setSpecialRestriction(classDatatype.getSpecialRestriction() + input);
                return 15;
            }

        }else if(state == 16){ //Course Description
            if(input.substring(input.length()-1).equalsIgnoreCase("*") && input.substring(1,2).equalsIgnoreCase("*")){
                classDatatype.setCourseDescription(input.substring(2,input.length()-1));
                return 2;
            }else if(input.substring(input.length()-1).equalsIgnoreCase("*")){
                classDatatype.setCourseDescription(classDatatype.getCourseDescription() + input.substring(0,input.length()-1));
                return 2;
            }else{
                classDatatype.setCourseDescription(classDatatype.getCourseDescription() + input);
                return 16;
            }

        }else if(state == 17){ //other
            if(input.substring(input.length()-1).equalsIgnoreCase("*")){
//                classDatatype.setOther(classDatatype.getOther() + input + ";");
                return 2;
            }else{
//                classDatatype.setOther(classDatatype.getOther() + input);
                return 17;
            }

        }else{
            return -1;
        }

//        return -1;
    }


}
