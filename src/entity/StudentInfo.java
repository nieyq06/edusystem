package entity;

/**
 * Author: nyq
 * Date：2022/5/26
 * Description: 介绍
 * Version： 1.0
 */
public class StudentInfo {
    public int UserId;
    public String UserNo;
    public String UserName;
    public String Sex;
    public String Tel;
    public String FacultyName;
    public String SubjectName;
    public String FacultyId;
    public String SubjectId;

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

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
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

    public StudentInfo(int userId, String userNo, String userName, String sex, String tel, String facultyName, String subjectName, String facultyId, String subjectId) {
        UserId = userId;
        UserNo = userNo;
        UserName = userName;
        Sex = sex;
        Tel = tel;
        FacultyName = facultyName;
        SubjectName = subjectName;
        FacultyId = facultyId;
        SubjectId = subjectId;
    }

    public StudentInfo() {
    }
}
