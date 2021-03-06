package dao.impl;

import dao.CommonDao;
import entity.StuSelectCourse;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/25
 * Description: 介绍
 * Version： 1.0
 */
public class CommonDaoImpl implements CommonDao {
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public long teacherCount(String selectFuzzy, String faculty) {
        long count = 0;
        String sql = "select count(*) from user u join course c on u.majorcourse = c.courseid join faculty f on u.facultyid=f.facultyid where 1=1 and  roleid = \"2\"";
        if(!selectFuzzy.equals("")){
            sql += " and (u.userno like \"%"+selectFuzzy+"%\" or u.username like \"%"+selectFuzzy+"%\" or c.coursename like \"%"+selectFuzzy+"%\")";
        }
        if(!faculty.equals("")){
            sql += " and f.facultyid =\""+faculty+"\"";
        }
        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long studentCount(String selectFuzzy, String faculty) {
        long count = 0;
        String sql = "select count(*) from user u join subject s on u.subjectid = s.subjectid join faculty f on u.facultyid=f.facultyid where 1=1 and  roleid = \"3\"";
        if(!selectFuzzy.equals("")){
            sql += " and (u.userno like \"%"+selectFuzzy+"%\" or u.username like \"%"+selectFuzzy+"%\" or s.subjectname like \"%"+selectFuzzy+"%\")";
        }
        if(!faculty.equals("")){
            sql += " and f.facultyid =\""+faculty+"\"";
        }
        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long courseCount(String selectFuzzy, String faculty) {
        long count = 0;
        String sql = "select count(*) from course where 1=1";
        if(!selectFuzzy.equals("")){
            sql += " and coursename like \"%"+selectFuzzy+"%\" ";
        }
        if(!faculty.equals("")){
            sql += " and facultyid =\""+faculty+"\"";
        }
        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long facultyCount(String facultyId, String facultyName) {
        long count = 0;
        String sql = "select count(*) from faculty where 1=1";
        if(!facultyId.equals("")){
            sql += " and coursename like \"%"+facultyId+"%\" ";
        }
        if(!facultyName.equals("")){
            sql += " and facultyid =\""+facultyName+"\"";
        }
        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int userInfoUpdate(User user,String role){
        int result = 0;
        try {
            if(role.equals("admin")){
                String sql = "update user set tel=? where userno=? ";
                result = queryRunner.update(DbUtils.getConnection(),sql,user.getTel(),user.getUserNo());
            }else if(role.equals("tch")){

            }else if(role.equals("stu")){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int userUpdatePwd(String newPwd, String oldPwd, String uno) {
        int result = 0;
        try {
            String select = "select * from user where userno=? and password=?";
            User user = queryRunner.query(DbUtils.getConnection(),select,new BeanHandler<User>(User.class),uno,oldPwd);
            if(user!=null){
                String sql = "update user set password=? where userno=?";
                result = queryRunner.update(DbUtils.getConnection(),sql,newPwd,uno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public long courseCountByTeacherNo(String course, String teacherNo) {
        long count = 0;
        String sql = "select count(*) from course where 1=1";
        if(!course.equals("")){
            sql += " and coursename like \"%"+course+"%\" ";
        }
        if(!teacherNo.equals("")){
            sql += " and teacherno =\""+teacherNo+"\"";
        }
        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long cjlrCountByTeacherNo(String stuNo, String stuName, String teacherNo) {
        long count = 0;
        String sql = "select count(*) from course c join score s on c.courseid=s.courseid join user u on s.userno=u.userno join faculty f on f.facultyid=c.facultyid join subject sub on u.subjectid=sub.subjectid where c.teacherno=?";
        if(!stuNo.equals("")){
            sql += " and u.userno like \"%"+stuNo+"%\"";
        }
        if(!stuName.equals("")){
            sql += " and u.username =\""+stuName+"\"";
        }
        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler(),teacherNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long xsxk(String selectC,String stuNo) {
        long count = 0;
        String sql = "select count(*) from course c join faculty f on c.facultyid=f.facultyid join user u on c.teacherno=u.userno where 1=1  and CourseId not in(select CourseId from score where userno=?)";
        if(!selectC.equals("")){
            sql += " and (c.CourseId like \"%"+selectC+"%\" or c.CourseName like \"%"+selectC+"%\" or u.username like \"%"+selectC+"%\" or u.username like \"%"+selectC+"%\")";
        }

        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler(),stuNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long yxkc(String selectC, String stuNo) {
        long count = 0;
        String sql = "select count(*) from course c join faculty f on c.facultyid=f.facultyid join user u on c.teacherno=u.userno where 1=1  and CourseId in(select CourseId from score where userno=?)";
        if(!selectC.equals("")){
            sql += " and (c.CourseId like \"%"+selectC+"%\" or c.CourseName like \"%"+selectC+"%\" or u.username like \"%"+selectC+"%\" or u.username like \"%"+selectC+"%\")";
        }

        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler(),stuNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
