package service;

import entity.StuSelectCourse;
import entity.TeacherInfo;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */
public interface TeacherService {
    public List<TeacherInfo> getByAll();

    public List<StuSelectCourse> STU_SELECT_COURSES (int page, int number, String stuNo, String stuName, String teacherNo);
    public int updateScore(String stuNo,double score,String courseId);

}
