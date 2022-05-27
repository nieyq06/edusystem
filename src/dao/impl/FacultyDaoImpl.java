package dao.impl;

import dao.FacultyDao;
import entity.Course;
import entity.Faculty;
import entity.TeacherInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/20
 * Description: 介绍
 * Version： 1.0
 */
public class FacultyDaoImpl implements FacultyDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public Faculty getById(String id) {
        String sql = "select * from faculty where facultyid=?";
        try {
            Faculty faculty = queryRunner.query(DbUtils.getConnection(),sql, new BeanHandler<Faculty>(Faculty.class),id);
            return faculty;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Faculty> getByAll(int page, int number, String facultyId, String facultyName) {
        int _page = (page-1) * 15;
        String sql = "select facultyid, facultyname from faculty where 1=1 ";

        if(!facultyId.equals("")){
            sql += " and facultyid like \"%"+facultyId+"%\" ";
        }
        if(!facultyName.equals("")){
            sql += " and facultyname =\""+facultyName+"\"";
        }
        sql +="  limit ?,?";
        try {
            List<Faculty> courses = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<Faculty>(Faculty.class),_page,number);
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Faculty> getByAll_cache() {
        String sql = "select * from faculty";
        try {
            List<Faculty> facultys = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<Faculty>(Faculty.class));
            return facultys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Faculty faculty) {
        String sql = "insert into faculty(facultyid,facultyname) values(?,?)";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,faculty.getFacultyId(),faculty.getFacultyName());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Faculty faculty) {
        String sql = "update faculty set facultyname=? where facultyid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,faculty.getFacultyName(),faculty.getFacultyId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String id) {
        String sql = "delete from faculty where facultyid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
