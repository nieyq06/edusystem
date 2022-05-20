package dao.impl;

import dao.TeacherDao;
import entity.Faculty;
import entity.TeacherInfo;
import entity.User;
import org.apache.commons.dbutils.BaseResultSetHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: TeacherDao实现
 * Version： 1.0
 */
public class TeacherDaoImpl implements TeacherDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<TeacherInfo> getByAll() {
//        String sql = "select * from user where roleid=?";
        String sql = "select c.userid,u.username,u.sex,u.tel,f.facultyname,c.coursename from user u left join course c on u.userid = c.userid left join faculty f on u.facultyid=f.facultyid where roleid=?";
        try {
            List<TeacherInfo> tchs = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<TeacherInfo>(TeacherInfo.class),2);
            return tchs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TeacherInfo getById(String id) {
        String sql = "select c.userid,u.username,u.sex,u.tel,f.facultyname,c.coursename from user u left join course c on u.userid = c.userid left join faculty f on u.facultyid=f.facultyid where roleid=? and userid=?";
        try {
            TeacherInfo tch = queryRunner.query(DbUtils.getConnection(),sql, new BeanHandler<TeacherInfo>(TeacherInfo.class),2,id);
            return tch;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(User user) {
        String sql="update user set roleid=?,username=?,sex=?,majorcourse=?,facultyid=?,tel=? where userid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql, new BeanHandler<User>(User.class),2,user.getUserName(),user, user.getSex(),user.getMajorCourse(),user.getFacultyId(),user.getTel(),user.getUserId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String id) {
        String sql="delete from user where roleid=? and userid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql, new BeanHandler<User>(User.class),2,id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
