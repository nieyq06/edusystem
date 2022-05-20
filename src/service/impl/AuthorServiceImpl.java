package service.impl;

import dao.AuthorDao;
import dao.impl.AuthorDaoImpl;
import entity.User;
import service.AuthorService;
import utils.DbUtils;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 介绍
 * Version： 1.0
 */
public class AuthorServiceImpl implements AuthorService {
    private AuthorDao authorDao = new AuthorDaoImpl();
    @Override
    public User login(String userid, String password) {
        User user = null;
        try {
            User temp = authorDao.select(userid);
            if (temp != null) {
                if(temp.getPassword().equals(password)){
                    user = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return user;
    }
}
