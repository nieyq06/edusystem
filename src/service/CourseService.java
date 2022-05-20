package service;

import entity.Course;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/21
 * Description: 介绍
 * Version： 1.0
 */
public interface CourseService {

    public Course getById(String id);
    public List<Course> getByAll();
    public int insert(Course course);
    public int update(Course course);
    public int delete(String id);
}
