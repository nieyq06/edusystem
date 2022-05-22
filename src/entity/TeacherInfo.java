package entity;

/**
 * Author: nyq
 * Date：2022/5/20
 * Description: 教师信息模型
 * Version： 1.0
 */
public class TeacherInfo {
    private String UserId;//用户id
    private String UserNo;//用户编号
    private String UserName;//用户名称
    private String Sex;//性别
    private String Tel;//电话
    private String FacultyName;//归属二级学院
    private String CourseName;//主教课程
    private String FacultyId;//归属二级学院id
    private String CourseId;//主教课程id

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
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

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
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

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public TeacherInfo(String userId, String userNo, String userName, String sex, String tel, String facultyName, String courseName, String facultyId, String courseId) {
        UserId = userId;
        UserNo = userNo;
        UserName = userName;
        Sex = sex;
        Tel = tel;
        FacultyName = facultyName;
        CourseName = courseName;
        FacultyId = facultyId;
        CourseId = courseId;
    }

    public TeacherInfo() {
    }
}
