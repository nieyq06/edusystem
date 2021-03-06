package entity;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 用户
 * Version： 1.0
 */
public class User {
    private int UserId;//id
    private String UserNo;//用户编号，用于登录
    private String Password;//密码
    private String UserName;//名字
    private String Sex; //性别
    private String MajorCourse;//主讲课程
    private String FacultyId;//院系
    private String SubjectId;//专业
    private String RoleId;//角色 1 管理员 2教师 3学生
    private String Tel;//电话

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserNo() {
        return UserNo;
    }

    public void setUserNo(String userNo) {
        UserNo = userNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    public String getMajorCourse() {
        return MajorCourse;
    }

    public void setMajorCourse(String majorCourse) {
        MajorCourse = majorCourse;
    }

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String subjectId) {
        SubjectId = subjectId;
    }

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String roleId) {
        RoleId = roleId;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public User(int userId, String userNo, String password, String userName, String sex, String majorCourse, String facultyId, String subjectId, String roleId, String tel) {
        UserId = userId;
        UserNo = userNo;
        Password = password;
        UserName = userName;
        Sex = sex;
        MajorCourse = majorCourse;
        FacultyId = facultyId;
        SubjectId = subjectId;
        RoleId = roleId;
        Tel = tel;
    }

    public User() {
    }
}
