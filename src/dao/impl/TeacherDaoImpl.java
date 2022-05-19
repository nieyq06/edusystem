package dao.impl;

import dao.TeacherDao;
import entity.User;
import org.apache.commons.dbutils.BaseResultSetHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: TeacherDao实现
 * Version： 1.0
 */
public class TeacherDaoImpl implements TeacherDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<User> getByAll() {
        String sql = "select * from user where roleid=?";
        try {
            List<User> users = queryRunner.query(DbUtils.getConnection(),sql, new BeanListHandler<User>(User.class),2);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
