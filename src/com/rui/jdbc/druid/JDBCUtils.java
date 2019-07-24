package com.rui.jdbc.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author rui
 * @create 2019-07-23 19:05
 */
public class JDBCUtils {
    private static DataSource dataSource;

    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取DateSource
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取链接
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 归还连接
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();//归还链接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }

    /**
     *
     * @return 连接池
     */
    public static  DataSource getDataSource(){
        return dataSource;
    }


}
