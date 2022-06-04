package dao.impl;

import dao.TeacherDao;
import entity.*;
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
    public TeacherInfo getById(String id) {
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
    public int update(User user) {
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

    @Override
    public List<StuSelectCourse> STU_SELECT_COURSES(int page, int number, String stuNo, String stuName,String teacherNo) {
        int _page = (page-1) * 15;
        String sql = "select c.courseid,c.coursename,c.credit,u.userno,c.teacherno,u.username,f.facultyname,c.facultyid,if(s.scores=0.00,'',s.scores) as scores,u.subjectid,sub.subjectname from course c join score s on c.courseid=s.courseid join user u on s.userno=u.userno join faculty f on f.facultyid=c.facultyid join subject sub on u.subjectid=sub.subjectid where c.teacherno=?";

        if(!stuNo.equals("")){
            sql += " and u.userno like \"%"+stuNo+"%\"";
        }
        if(!stuName.equals("")){
            sql += " and u.username =\""+stuName+"\"";
        }
        sql +="  limit ?,?";
        try {
            List<StuSelectCourse> tchs = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<StuSelectCourse>(StuSelectCourse.class),teacherNo,_page,number);
            return tchs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateScore(String stuNo, double score,String courseId) {
        String sql="update score set scores=? where userno=? and courseid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,score,stuNo,courseId);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
