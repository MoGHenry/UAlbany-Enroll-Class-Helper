package datatype;

public class ClassDatatype {

    private String level; //3
    private String departmentOrProgram; //4
    private String classNumber; //5
    private String courseInfo; //6
    private String meetingInfo; //7
    private String comments; //8
    private String creditRange; //9
    private String componentIsBlankIfLecture; //10
    private String seatsRemainingAsOfLastUpdate; //11
    private String session; //12
    private String courseDeliveryMethod; //13
    private String generalEducationCourse; //14
    private String specialRestriction; //15
    private String courseDescription; //16
    private String other; //17

    public ClassDatatype() {
        this.level = "";
        this.departmentOrProgram = "";
        this.classNumber = "";
        this.courseInfo = "";
        this.meetingInfo = "";
        this.comments = "";
        this.creditRange = "";
        this.componentIsBlankIfLecture = "";
        this.seatsRemainingAsOfLastUpdate = "";
        this.session = "";
        this.courseDeliveryMethod = "";
        this.generalEducationCourse = "";
        this.specialRestriction = "";
        this.courseDescription = "";
        this.other = "";
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartmentOrProgram() {
        return departmentOrProgram;
    }

    public void setDepartmentOrProgram(String departmentOrProgram) {
        this.departmentOrProgram = departmentOrProgram;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public String getMeetingInfo() {
        return meetingInfo;
    }

    public void setMeetingInfo(String meetingInfo) {
        this.meetingInfo = meetingInfo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreditRange() {
        return creditRange;
    }

    public void setCreditRange(String creditRange) {
        this.creditRange = creditRange;
    }

    public String getComponentIsBlankIfLecture() {
        return componentIsBlankIfLecture;
    }

    public void setComponentIsBlankIfLecture(String componentIsBlankIfLecture) {
        this.componentIsBlankIfLecture = componentIsBlankIfLecture;
    }

    public String getSeatsRemainingAsOfLastUpdate() {
        return seatsRemainingAsOfLastUpdate;
    }

    public void setSeatsRemainingAsOfLastUpdate(String seatsRemainingAsOfLastUpdate) {
        this.seatsRemainingAsOfLastUpdate = seatsRemainingAsOfLastUpdate;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCourseDeliveryMethod() {
        return courseDeliveryMethod;
    }

    public void setCourseDeliveryMethod(String courseDeliveryMethod) {
        this.courseDeliveryMethod = courseDeliveryMethod;
    }

    public String getGeneralEducationCourse() {
        return generalEducationCourse;
    }

    public void setGeneralEducationCourse(String generalEducationCourse) {
        this.generalEducationCourse = generalEducationCourse;
    }

    public String getSpecialRestriction() {
        return specialRestriction;
    }

    public void setSpecialRestriction(String specialRestriction) {
        this.specialRestriction = specialRestriction;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "ClassDatatype{" +
                "level='" + level + "\'\n" +
                "departmentOrProgram='" + departmentOrProgram + "\'\n" +
                "classNumber='" + classNumber + "\'\n" +
                "courseInfo='" + courseInfo + "\'\n" +
                "meetingInfo='" + meetingInfo + "\'\n" +
                "comments='" + comments + "\'\n" +
                "creditRange='" + creditRange + "\'\n"+
                "componentIsBlankIfLecture='" + componentIsBlankIfLecture + "\'\n" +
                "seatsRemainingAsOfLastUpdate='" + seatsRemainingAsOfLastUpdate + "\'\n" +
                "session='" + session + "\'\n" +
                "courseDeliveryMethod='" + courseDeliveryMethod + "\'\n" +
                "generalEducationCourse='" + generalEducationCourse + "\'\n" +
                "specialRestriction='" + specialRestriction + "\'\n" +
                "courseDescription='" + courseDescription + "\'\n" +
                "other='" + other + "\'\n" +
                '}';
    }
}
