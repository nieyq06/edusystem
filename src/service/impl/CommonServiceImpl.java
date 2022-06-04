package service.impl;

import dao.CommonDao;
import dao.impl.CommonDaoImpl;
import entity.Course;
import entity.User;
import service.CommonService;
import utils.DbUtils;

import java.util.List;

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

    @Override
    public long facultyCount(String facultyId, String facultyName) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.facultyCount(facultyId,facultyName);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int userInfoUpdate(User user, String role) {
        int result = 0;
        try {
            DbUtils.begin();
            result = commonDao.userInfoUpdate(user,role);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int userUpdatePwd(String newPwd, String oldPwd, String uno) {
        int result = 0;
        try {
            DbUtils.begin();
            result = commonDao.userUpdatePwd(newPwd,oldPwd,uno);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public long getCourseAllByTeacherId( String course, String teacherNo) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.courseCountByTeacherNo(course,teacherNo);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long cjlrCountByTeacherNo(String stuNo, String stuName, String teacherNo) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.cjlrCountByTeacherNo(stuNo,stuName,teacherNo);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long xsxk(String selectC,String stuNo) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.xsxk(selectC,stuNo);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long yxkc(String selectC,String stuNo) {
        long count = 0;
        try {
            DbUtils.begin();
            count = commonDao.xsxk(selectC,stuNo);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return count;
    }
}
