package service.impl;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import entity.StuSelectCourse;
import entity.TeacherInfo;
import entity.User;
import service.TeacherService;
import utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public List<TeacherInfo> getByAll() {
        List<TeacherInfo> tchs = new ArrayList<>();
        try {
            DbUtils.begin();
            List<TeacherInfo> temps = teacherDao.getByAll();
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
    public List<StuSelectCourse> STU_SELECT_COURSES(int page, int number, String stuNo, String stuName, String teacherNo) {
        List<StuSelectCourse> stuSelectCourses = new ArrayList<>();
        try {
            DbUtils.begin();
            List<StuSelectCourse> temps = teacherDao.STU_SELECT_COURSES(page,number,stuNo,stuName,teacherNo);
            if (temps!=null){
                stuSelectCourses = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return stuSelectCourses;
    }

    @Override
    public int updateScore(String stuNo, double score,String courseId) {
        int result = 0;
        try {
            DbUtils.begin();
            result = teacherDao.updateScore(stuNo,score,courseId);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
