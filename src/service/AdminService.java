package service;

import cn.hutool.system.UserInfo;
import entity.StudentInfo;
import entity.TeacherInfo;
import entity.User;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */
public interface AdminService {
    public List<TeacherInfo> getTeacherByAll(int page,int number,String selectFuzzy, String faculty);
    public TeacherInfo getTeacherById(int id);
    public int insertTeacher(User user);
    public int updateTeacher(User user);
    public int deleteTeacher(int id);


    public List<StudentInfo> getStudentByAll(int page, int number, String selectFuzzy, String faculty );
    public StudentInfo getStudentById(int id);
    public int insertStudent(User user);
    public int updateStudent(User user);
    public int deleteStudent(int id);
}
