package service;

import entity.User;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 用户身份验证服务
 * Version： 1.0
 */
public interface AuthorService {
    public User login(String userid, String password);
    public long registerCheck(String userno);
    public long register(User user);
}
