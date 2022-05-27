package dao;

import entity.Faculty;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/20
 * Description: 介绍
 * Version： 1.0
 */
public interface FacultyDao {
    public Faculty getById(String id);
    public List<Faculty> getByAll(int page, int number, String facultyId, String facultyName );
    public List<Faculty> getByAll_cache();
    public int insert(Faculty faculty);
    public int update(Faculty faculty);
    public int delete(String id);

}
