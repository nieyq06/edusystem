package dao;

import entity.Course;

import javax.crypto.interfaces.PBEKey;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/21
 * Description: 介绍
 * Version： 1.0
 */
public interface CourseDao {
    public Course getById(String id);
    public List<Course> getByAll(int page, int number, String course, String faculty );
    public List<Course> getByAll_cache();
    public int insert(Course course);
    public int update(Course course);
    public int updateAtTch(Course course);
    public int delete(String id);


    public List<Course> getAllByTeacherNo(int page, int number, String course, String teacherNo);

}
