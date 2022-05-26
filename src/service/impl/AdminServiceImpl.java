package service.impl;

import cn.hutool.system.UserInfo;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.StudentInfo;
import entity.TeacherInfo;
import entity.User;
import service.AdminService;
import utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */
public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public List<TeacherInfo> getTeacherByAll(int page,int number,String selectFuzzy, String faculty) {
        List<TeacherInfo> tchs = new ArrayList<>();
        try {
            DbUtils.begin();
            List<TeacherInfo> temps = adminDao.getTeacherByAll(page,number,selectFuzzy,faculty);
            if (temps!=null){
                tchs = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return tchs;
    }

    @Override
    public TeacherInfo getTeacherById(int id) {
        TeacherInfo result= null;
        try {
            DbUtils.begin();
            TeacherInfo temp = adminDao.getTeacherById(id);
            if(temp!=null){
                result = temp;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertTeacher(User user) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.insertTeacher(user);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateTeacher(User user) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.updateTeacher(user);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteTeacher(int id) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.deleteTeacher(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<StudentInfo> getStudentByAll(int page, int number, String selectFuzzy, String faculty) {
        List<StudentInfo> stus = new ArrayList<>();
        try {
            DbUtils.begin();
            List<StudentInfo> temps = adminDao.getStudentByAll(page,number,selectFuzzy,faculty);
            if (temps!=null){
                stus = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return stus;
    }

    @Override
    public StudentInfo getStudentById(int id) {
        StudentInfo result= null;
        try {
            DbUtils.begin();
            StudentInfo temp = adminDao.getStudentById(id);
            if(temp!=null){
                result = temp;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertStudent(User user) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.insertStudent(user);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateStudent(User user) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.updateStudent(user);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteStudent(int id) {
        int result = 0;
        try {
            DbUtils.begin();
            result = adminDao.deleteStudent(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;    }
}
