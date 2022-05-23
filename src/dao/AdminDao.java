package dao;

import entity.TeacherInfo;
import entity.User;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */
public interface AdminDao {
    public List<TeacherInfo> getTeacherByAll();
    public TeacherInfo getTeacherById(int id);
    public int insertTeacher(User user);
    public int updateTeacher(User user);
    public int deleteTeacher(String id);
}
