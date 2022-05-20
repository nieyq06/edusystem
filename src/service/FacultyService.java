package service;

import entity.Faculty;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/20
 * Description: 介绍
 * Version： 1.0
 */
public interface FacultyService {
    public Faculty getById(String id);
    public List<Faculty> getByAll();
    public int update(Faculty faculty);
    public int delete(String id);

}
