package entity;

/**
 * Author: nyq
 * Date：2022/6/3
 * Description: 介绍
 * Version： 1.0
 */
public class StuSelectCourse {
    private String UserNo;
    private String UserName;
    private String FacultyId;
    private String FacultyName;
    private String SubjectId;
    private String SubjectName;
    private String CourseId;
    private String CourseName;
    private String Credit;
    private String TeacherNo;
    private String TeacherName;
    private double Scores;

    public StuSelectCourse(String userNo, String userName, String facultyId, String facultyName, String subjectId, String subjectName, String courseId, String courseName, String credit, String teacherNo, String teacherName, double scores) {
        UserNo = userNo;
        UserName = userName;
        FacultyId = facultyId;
        FacultyName = facultyName;
        SubjectId = subjectId;
        SubjectName = subjectName;
        CourseId = courseId;
        CourseName = courseName;
        Credit = credit;
        TeacherNo = teacherNo;
        TeacherName = teacherName;
        Scores = scores;
    }

    public double getScores() {
        return Scores;
    }

    public void setScores(double scores) {
        Scores = scores;
    }

    public String getUserNo() {
        return UserNo;
    }

    public void setUserNo(String userNo) {
        UserNo = userNo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String subjectId) {
        SubjectId = subjectId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String credit) {
        Credit = credit;
    }

    public String getTeacherNo() {
        return TeacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        TeacherNo = teacherNo;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }


    public StuSelectCourse() {
    }


}
