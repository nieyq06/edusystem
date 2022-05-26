package service;

import entity.Subject;

import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/27
 * Description: 介绍
 * Version： 1.0
 */
public interface SubjectService {
    public List<Subject> getByAll(int page, int number, String selectFuzzy, String faculty );
    public List<Subject> getByAll_cache();
    public Subject getById(int id);
    public int insert(Subject subject);
    public int update(Subject subject);
    public int delete(int id);
}
