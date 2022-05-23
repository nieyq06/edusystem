package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.TeacherInfo;
import service.AdminService;
import utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/23
 * Description: 介绍
 * Version： 1.0
 */
public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public List<TeacherInfo> getTeacherByAll() {
        List<TeacherInfo> tchs = new ArrayList<>();
        try {
            DbUtils.begin();
            List<TeacherInfo> temps = adminDao.getTeacherByAll();
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

    @Override
    public TeacherInfo getTeacherById(String id) {
        TeacherInfo result= null;
        try {
            DbUtils.begin();
            TeacherInfo temp = adminDao.getTeacherById(id);
            if(temp!=null){
                result = temp;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;    }
}
