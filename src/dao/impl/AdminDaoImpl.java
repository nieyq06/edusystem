package dao.impl;

import dao.AdminDao;
import entity.TeacherInfo;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */
public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<TeacherInfo> getTeacherByAll() {
        String sql = "select u.userid,u.userno,u.username,u.sex,u.tel,f.facultyname,c.coursename from user u join course c on u.majorcourse = c.courseid join faculty f on u.facultyid=f.facultyid where roleid=?";
        try {
            List<TeacherInfo> tchs = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<TeacherInfo>(TeacherInfo.class),2);
            return tchs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TeacherInfo getTeacherById(String id) {
        String sql = "select u.userid,u.userno,u.username,u.sex,u.tel,f.facultyname,c.coursename,u.facultyid,c.courseid  from user u join course c on u.MajorCourse = c.CourseId join faculty f on u.facultyid=f.facultyid  where u.roleid=? and u.userid=?";
        try {
            TeacherInfo tch = queryRunner.query(DbUtils.getConnection(),sql, new BeanHandler<TeacherInfo>(TeacherInfo.class),2,id);
            return tch;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertTeacher(User user) {
        String sql = "insert into user(userno,username,sex,majorcourse,facultyid,tel,roleid,password) value(?,?,?,?,?,?,?,?) ";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,user.getUserNo(),user.getUserName(),user.getSex(),user.getMajorCourse(),user.getFacultyId(),user.getTel(),"2","Nie@123");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateTeacher(User user) {
        String sql="update user set userno=?,username=?,sex=?,majorcourse=?,facultyid=?,tel=? where userid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,user.getUserNo(),user.getUserName(), user.getSex(),user.getMajorCourse(),user.getFacultyId(),user.getTel(),user.getUserId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteTeacher(String id) {
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
