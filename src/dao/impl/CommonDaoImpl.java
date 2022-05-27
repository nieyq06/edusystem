package dao.impl;

import dao.CommonDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DbUtils;

import java.sql.SQLException;

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
}
