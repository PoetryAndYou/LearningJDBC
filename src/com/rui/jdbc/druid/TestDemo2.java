package com.rui.jdbc.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author rui
 * @create 2019-07-23 17:35
 */
public class TestDemo2 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        TestDemo2 testDemo2 = new TestDemo2();
        InputStream resourceAsStream = testDemo2.getClass().getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
