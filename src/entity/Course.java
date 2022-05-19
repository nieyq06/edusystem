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
    private String TeacherId;//任课教师id
    private double Credit;//学分

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

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public double getCredit() {
        return Credit;
    }

    public void setCredit(double credit) {
        Credit = credit;
    }

    public Course(String courseId, String courseName, String teacherId, double credit) {
        CourseId = courseId;
        CourseName = courseName;
        TeacherId = teacherId;
        Credit = credit;
    }

    public Course() {
    }
}
