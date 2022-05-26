package service.impl;

import dao.SubjectDao;
import dao.impl.SubjectDaoImpl;
import entity.Subject;
import service.SubjectService;
import utils.DbUtils;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */
public class SubjectServiceImpl implements SubjectService {
    SubjectDao subjectDao = new SubjectDaoImpl();
    @Override
    public List<Subject> getByAll(int page, int number, String selectFuzzy, String faculty) {
        return null;
    }

    @Override
    public List<Subject> getByAll_cache() {
        List<Subject> subjects = null;
        try {
            subjects = subjectDao.getByAll_cache();
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return subjects;
    }

    @Override
    public Subject getById(int id) {
        return null;
    }

    @Override
    public int insert(Subject subject) {
        return 0;
    }

    @Override
    public int update(Subject subject) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
