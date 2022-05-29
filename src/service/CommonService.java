package service;

import entity.User;

/**
 * Author: nyq
 * Date：2022/5/26
 * Description: 介绍
 * Version： 1.0
 */
public interface CommonService {
    public long teacherCount( String selectFuzzy,String faculty);
    public long studentCount( String selectFuzzy,String faculty);
    public long courseCount( String selectFuzzy,String faculty);
    public long facultyCount( String facultyId,String facultyName);
    public int userInfoUpdate(User user, String role);
    public int userUpdatePwd(String newPwd,String oldPwd,String uno);
}
