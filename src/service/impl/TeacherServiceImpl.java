package service.impl;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import entity.TeacherInfo;
import entity.User;
import service.TeacherService;
import utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();
    @Override
    public List<TeacherInfo> getByAll() {
        List<TeacherInfo> tchs = new ArrayList<>();
        try {
            DbUtils.begin();
            List<TeacherInfo> temps = teacherDao.getByAll();
            if (temps!=null){
                tchs = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return tchs;
    }
}
