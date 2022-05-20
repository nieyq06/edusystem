package dao;

import entity.Faculty;

import javax.crypto.interfaces.PBEKey;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/20
 * Description: 介绍
 * Version： 1.0
 */
public interface FacultyDao {
    public Faculty getById(String id);
    public List<Faculty> getByAll();
    public int update(Faculty faculty);
    public int delete(String id);

}
