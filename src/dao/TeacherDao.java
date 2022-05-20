package dao;

import entity.TeacherInfo;
import entity.User;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 关于教师的所有操作
 * Version： 1.0
 */
public interface TeacherDao {
    public List<TeacherInfo> getByAll();
    public TeacherInfo getById(String id);
    public int update(User user);
    public int delete(String id);
}
