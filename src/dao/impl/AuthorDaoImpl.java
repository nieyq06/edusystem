package dao.impl;

import dao.AuthorDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DbUtils;

import java.sql.SQLException;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 用户身份验证DAO实现
 * Version： 1.0
 */
public class AuthorDaoImpl implements AuthorDao {
    private QueryRunner queryRunner =new QueryRunner();
    @Override
    public User select(String userno) {
        String sql = "select * from User where userno=?";
        try {
            User user = queryRunner.query(DbUtils.getConnection(),sql,new BeanHandler<User>(User.class),userno);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
