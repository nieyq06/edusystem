package dao.impl;

import dao.CourseDao;
import entity.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
        String sql = "select c.courseid,c.coursename,c.credit,c.facultyid,c.teacherno,f.facultyid from course c join faculty f on c.facultyid=f.facultyid where c.courseid=?";
        try {
            Course course = queryRunner.query(DbUtils.getConnection(),sql, new BeanHandler<Course>(Course.class),id);
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> getByAll(int page, int number, String course, String faculty) {
        int _page = (page-1) * 15;
        String sql = "select c.courseid,c.coursename,c.credit,c.facultyid,c.teacherno,f.facultyname from course c join faculty f on c.facultyid=f.facultyid where 1=1";

        if(!course.equals("")){
            sql += " and c.coursename like \"%"+course+"%\" ";
        }
        if(!faculty.equals("")){
            sql += " and c.facultyid =\""+faculty+"\"";
        }
        sql +="  limit ?,?";
        System.out.println(sql);
        try {
            List<Course> courses = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<Course>(Course.class),_page,number);
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> getByAll_cache() {

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
        String sql = "insert into course(courseid,coursename,credit,facultyid,teacherno) values(?,?,?,?,?)";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,course.getCourseId(),course.getCourseName(),course.getCredit(),course.getFacultyId(),course.getTeacherNo());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Course course) {
        String sql = "update course set coursename=?,credit=?,facultyid=?,teacherno=? where courseid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,course.getCourseName(),course.getCredit(),course.getFacultyId(),course.getTeacherNo(),course.getCourseId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateAtTch(Course course) {
        System.out.println(course);
        String sql = "update course set coursename=?,credit=?,facultyid=?,teacherno=? where courseid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,course.getCourseName(),course.getCredit(),course.getFacultyId(),course.getTeacherNo(),course.getCourseId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int delete(String id) {
        String sql = "delete from course  where courseid=?";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Course> getAllByTeacherNo(int page, int number, String course, String teacherNo) {
        int _page = (page-1) * 15;
        String sql = "select c.courseid,c.coursename,c.credit,c.facultyid,f.facultyname from course c join faculty f on c.facultyid=f.facultyid where 1=1";

        if(!course.equals("")){
            sql += " and c.coursename like \"%"+course+"%\" ";
        }
        sql +=" and c.teacherno=? limit ?,?";
        System.out.println(sql);
        try {
            List<Course> courses = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<Course>(Course.class),teacherNo,_page,number);
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StuSelectCourse> xsxk(int page, int number, String selectC) {
        int _page = (page-1) * 15;
        String sql = "select c.courseid,coursename,c.credit,c.FacultyId,f.FacultyName,u.UserName from course c join faculty f on c.facultyid=f.facultyid join user u on c.teacherno=u.userno where 1=1";

        if(!selectC.equals("")){
            sql += " and (c.CourseId like \"%"+selectC+"%\" or c.CourseName like \"%"+selectC+"%\" or u.username like \"%"+selectC+"%\" or u.username like \"%\""+selectC+"\"%\")";
        }
        sql +="  limit ?,?";
        try {
            List<StuSelectCourse> stuSelectCourses = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<StuSelectCourse>(StuSelectCourse.class),_page,number);
            return stuSelectCourses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int stuAdd(String stuNo, String courseId) {
        String sql = "insert into score(userno,courseid,scores) values(?,?,?)";
        try {
            int result = queryRunner.update(DbUtils.getConnection(),sql,stuNo,courseId,0);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
