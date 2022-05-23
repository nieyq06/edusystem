package service;

import entity.TeacherInfo;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */
public interface AdminService {
    public List<TeacherInfo> getTeacherByAll();
    public TeacherInfo getTeacherById(int id);
}
