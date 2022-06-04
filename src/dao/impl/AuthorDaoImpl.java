package dao.impl;

import dao.AuthorDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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

    @Override
    public long registerCheck(String userno) {
        long count = 0;
        String sql = "select count(*) from user where userno=?";

        try {
            count = (long)queryRunner.query(DbUtils.getConnection(),sql,new ScalarHandler(),userno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long register(User user) {
        long count = 0;
        String sql = "insert into user(userno,Password,username,sex,SubjectId,FacultyId,tel,roleid) value(?,?,?,?,?,?,?,?)";

        try {
            count = (long)queryRunner.update(DbUtils.getConnection(),sql,user.getUserNo(),user.getPassword(),user.getUserName(),user.getSex(),user.getSubjectId(),user.getFacultyId(),user.getTel(),"3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
