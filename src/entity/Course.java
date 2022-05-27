package entity;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */
public class Course {
    private String CourseId;//课程id
    private String CourseName;//课程名
    private String FacultyId;//二级学院id
    private double Credit;//学分
    private String FacultyName;

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

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public double getCredit() {
        return Credit;
    }

    public void setCredit(double credit) {
        Credit = credit;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    public Course(String courseId, String courseName, String facultyId, double credit, String facultyName) {
        CourseId = courseId;
        CourseName = courseName;
        FacultyId = facultyId;
        Credit = credit;
        FacultyName = facultyName;
    }

    public Course() {
    }
}
