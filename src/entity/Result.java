package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: nyq
 * Date：2022/5/26
 * Description: 介绍
 * Version： 1.0
 */
public class Result {
    private long total;
//    private ArrayList rows ;
    private List<Object> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public Result(long total, List<Object> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Result() {
    }
}
