package dao;

import entity.Course;
import entity.StudentInfo;
import entity.Subject;
import entity.User;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/26
 * Description: 专业
 * Version： 1.0
 */
public interface SubjectDao {
    public List<Subject> getByAll(int page, int number, String selectFuzzy, String faculty );
    public List<Subject> getByAll_cache();
    public Subject getById(int id);
    public int insert(Subject subject);
    public int update(Subject subject);
    public int delete(int id);

}
