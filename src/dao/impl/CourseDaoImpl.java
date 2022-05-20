package dao.impl;

import dao.CourseDao;
import entity.Course;
import entity.Faculty;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/21
 * Description: 介绍
 * Version： 1.0
 */
public class CourseDaoImpl implements CourseDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public Course getById(String id) {
        return null;
    }

    @Override
    public List<Course> getByAll() {

        String sql = "select * from course";
        try {
            List<Course> courses = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<Course>(Course.class));
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
