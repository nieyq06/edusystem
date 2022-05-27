package dao;

/**
 * Author: nyq
 * Date：2022/5/25
 * Description: 介绍
 * Version： 1.0
 */
public interface CommonDao {
    public long teacherCount( String selectFuzzy,String faculty);
    public long studentCount( String selectFuzzy,String faculty);
    public long courseCount( String selectFuzzy,String faculty);
}
