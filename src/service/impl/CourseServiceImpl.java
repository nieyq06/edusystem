package service.impl;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import entity.Course;
import entity.Faculty;
import entity.TeacherInfo;
import service.CourseService;
import utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/21
 * Description: 介绍
 * Version： 1.0
 */
public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    @Override
    public Course getById(String id) {
        Course result= null;
        try {
            DbUtils.begin();
            Course temp = courseDao.getById(id);
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
    public List<Course> getByAll(int page, int number, String course, String faculty) {
        List<Course> courses = new ArrayList<>();
        try {
            DbUtils.begin();
            List<Course> temps = courseDao.getByAll(page,number,course,faculty);
            if (temps!=null){
                courses = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<Course> getByAll_cache() {
        List<Course> courses = null;
        try {
            courses = courseDao.getByAll_cache();
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public int insert(Course course) {
        int result = 0;
        try {
            DbUtils.begin();
            result = courseDao.insert(course);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Course course) {
        int result = 0;
        try {
            DbUtils.begin();
            result = courseDao.update(course);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(String id) {
        int result = 0;
        try {
            DbUtils.begin();
            result = courseDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Course> getAllByTeacherNo(int page, int number, String course, String teacherNo) {
        List<Course> courses = null;
        try {
            courses = courseDao.getAllByTeacherNo(page,number,course,teacherNo);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return courses;
    }
}
