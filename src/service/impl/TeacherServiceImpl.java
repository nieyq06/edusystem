package service.impl;

import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
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
    public List<User> getByAll() {
        List<User> users = new ArrayList<>();
        try {
            DbUtils.begin();
            List<User> temps = teacherDao.getByAll();
            if (temps!=null){
                users = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return users;
    }
}
