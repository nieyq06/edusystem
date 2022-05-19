package entity;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 成绩
 * Version： 1.0
 */
public class Score {
    private String StudentId;//学生学号
    private String CourseId;//课程号
    private String Scores;//分数

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getScores() {
        return Scores;
    }

    public void setScores(String scores) {
        Scores = scores;
    }

    public Score(String studentId, String courseId, String scores) {
        StudentId = studentId;
        CourseId = courseId;
        Scores = scores;
    }

    public Score() {
    }
}
