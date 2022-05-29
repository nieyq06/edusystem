package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 数据库链接类
 * Version： 1.0
 */
public class DbUtils {
    private static DruidDataSource ds;
    private static final ThreadLocal<Connection> THREAD_LOCAL =new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        InputStream inputStream= DbUtils.class.getResourceAsStream("/database.properties");
        try {
            properties.load(inputStream);
            ds=(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection =THREAD_LOCAL.get();
        try {
            if(connection==null){
                connection=ds.getConnection();
                THREAD_LOCAL.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void begin() {
        try {
            Connection connection =null;
            connection=getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void commit() {
        Connection connection=null;
        try {
            connection=getConnection();
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }

    }

    public static void rollback(){
        Connection connection=null;
        try {
            connection=getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }
    }

    private static void closeAll(Connection con, Statement st, ResultSet rs)  {
        try {
            if(con!=null){
                con.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
            THREAD_LOCAL.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
