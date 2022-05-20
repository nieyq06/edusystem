package service.impl;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import entity.Course;
import entity.Faculty;
import service.CourseService;
import utils.DbUtils;

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
        return null;
    }

    @Override
    public List<Course> getByAll() {
        List<Course> courses = null;
        try {
            courses = courseDao.getByAll();
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public int insert(Course course) {
        return 0;
    }

    @Override
    public int update(Course course) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
