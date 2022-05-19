package dao;

import entity.User;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 用户身份验证DAO
 * Version： 1.0
 */
public interface AuthorDao {
    public User select(String userid);
}
