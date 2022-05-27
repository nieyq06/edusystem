package service.impl;

import dao.CommonDao;
import dao.impl.CommonDaoImpl;
import service.CommonService;
import utils.DbUtils;

/**
 * Author: nyq
 * Date：2022/5/26
 * Description: 介绍
 * Version： 1.0
 */
public class CommonServiceImpl implements CommonService {
    CommonDao commonDao = new CommonDaoImpl();
    @Override
    public long teacherCount(String selectFuzzy, String faculty) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.teacherCount(selectFuzzy,faculty);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long studentCount(String selectFuzzy, String faculty) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.studentCount(selectFuzzy,faculty);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long courseCount(String selectFuzzy, String faculty) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.courseCount(selectFuzzy,faculty);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }
}
