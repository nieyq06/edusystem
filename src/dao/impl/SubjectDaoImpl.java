package dao.impl;

import dao.SubjectDao;
import entity.Course;
import entity.Subject;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */
public class SubjectDaoImpl implements SubjectDao {
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<Subject> getByAll(int page, int number, String selectFuzzy, String faculty) {
        return null;
    }

    @Override
    public List<Subject> getByAll_cache() {
        String sql = "select * from subject";
        try {
            List<Subject> courses = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<Subject>(Subject.class));
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Subject getById(int id) {
        return null;
    }

    @Override
    public int insert(Subject subject) {
        return 0;
    }

    @Override
    public int update(Subject subject) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
