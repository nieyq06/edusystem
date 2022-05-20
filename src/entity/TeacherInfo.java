package entity;

/**
 * Author: nyq
 * Date：2022/5/20
 * Description: 教师信息模型
 * Version： 1.0
 */
public class TeacherInfo {
    private String userid;//用户id
    private String username;//用户名称
    private String sex;//性别
    private String tel;//电话
    private String facultyname;//归属二级学院
    private String coursename;//主教课程

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public TeacherInfo(String userid, String username, String sex, String tel, String facultyname, String coursename) {
        this.userid = userid;
        this.username = username;
        this.sex = sex;
        this.tel = tel;
        this.facultyname = facultyname;
        this.coursename = coursename;
    }

    public TeacherInfo() {
    }
}
