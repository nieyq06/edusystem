package dao.impl;

import cn.hutool.system.UserInfo;
import dao.AdminDao;
import entity.StudentInfo;
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
    public List<TeacherInfo> getTeacherByAll(int page,int number,String selectFuzzy, String faculty) {
        int _page = (page-1) * 15;
        String sql = "select u.userid,u.userno,u.username,u.sex,u.tel,f.facultyname,c.coursename from user u join course c on u.majorcourse = c.courseid join faculty f on u.facultyid=f.facultyid where roleid=?";

        if(!selectFuzzy.equals("")){
            sql += " and (u.userno like \"%"+selectFuzzy+"%\" or u.username like \"%"+selectFuzzy+"%\" or c.coursename like \"%"+selectFuzzy+"%\")";
        }
        if(!faculty.equals("")){
            sql += " and f.facultyid =\""+faculty+"\"";
        }
        sql +="  limit ?,?";
        try {
            List<TeacherInfo> tchs = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<TeacherInfo>(TeacherInfo.class),"2",_page,number);
            return tchs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TeacherInfo getTeacherById(int id) {
        String sql = "select u.userid,u.userno,u.username,u.sex,u.tel,f.facultyname,c.coursename,u.facultyid,c.courseid  from user u join course c on u.MajorCourse = c.CourseId join faculty f on u.facultyid=f.facultyid  where u.roleid=? and u.userid=?";
        try {
            TeacherInfo tch = queryRunner.query(DbUtils.getConnection(),sql, new BeanHandler<TeacherInfo>(TeacherInfo.class),"2",id);
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
    public int deleteTeacher(int id) {
        String sql="delete from user where userid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql, id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<StudentInfo> getStudentByAll(int page, int number, String selectFuzzy, String faculty) {
        int _page = (page-1) * 15;
        String sql = "select u.userid,u.userno,u.username,u.sex,s.subjectname,f.facultyname,u.tel from user u join subject s on u.subjectid = s.subjectid join faculty f on u.facultyid=f.facultyid where roleid=?";

        if(!selectFuzzy.equals("")){
            sql += " and (u.userno like \"%"+selectFuzzy+"%\" or u.username like \"%"+selectFuzzy+"%\" or s.subjectname like \"%"+selectFuzzy+"%\")";
        }
        if(!faculty.equals("")){
            sql += " and f.facultyid =\""+faculty+"\"";
        }
        sql +="  limit ?,?";
        try {
            List<StudentInfo> tchs = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<StudentInfo>(StudentInfo.class),"3",_page,number);
            return tchs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StudentInfo getStudentById(int id) {
        String sql = "select u.userid,u.userno,u.username,u.sex,u.tel,f.facultyname,s.subjectname,u.facultyid,s.subjectid  from user u join subject s on u.subjectid = s.subjectid join faculty f on u.facultyid=f.facultyid  where u.userid=?";
        try {
            StudentInfo tch = queryRunner.query(DbUtils.getConnection(),sql, new BeanHandler<StudentInfo>(StudentInfo.class),id);
            return tch;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertStudent(User user) {
        String sql = "insert into user(userno,username,sex,subjectid,facultyid,tel,roleid,password) value(?,?,?,?,?,?,?,?) ";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,user.getUserNo(),user.getUserName(),user.getSex(),user.getSubjectId(),user.getFacultyId(),user.getTel(),"3","Nie@123");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateStudent(User user) {
        String sql="update user set userno=?,username=?,sex=?,subjectid=?,facultyid=?,tel=? where userid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,user.getUserNo(),user.getUserName(), user.getSex(),user.getSubjectId(),user.getFacultyId(),user.getTel(),user.getUserId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteStudent(int id) {
        String sql="delete from user where userid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql, id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
