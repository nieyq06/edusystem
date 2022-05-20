package service.impl;

import dao.FacultyDao;
import dao.impl.FacultyDaoImpl;
import entity.Faculty;
import service.FacultyService;
import utils.DbUtils;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/20
 * Description: 介绍
 * Version： 1.0
 */
public class FacultyServiceImpl implements FacultyService {
    FacultyDao facultyDao = new FacultyDaoImpl();
    @Override
    public Faculty getById(String id) {
        Faculty faculty = null;
        try {
            Faculty temp = facultyDao.getById(id);
            if (temp!=null){
                faculty=temp;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return faculty;
    }

    @Override
    public List<Faculty> getByAll() {
        List<Faculty> faculty = null;
        try {
            faculty = facultyDao.getByAll();
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return faculty;
    }

    @Override
    public int update(Faculty faculty) {
        int result = 0;
        try {
            result = facultyDao.update(faculty);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(String id) {
        int result = 0;
        try {
            result = facultyDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
