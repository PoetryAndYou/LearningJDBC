package com.rui.jdbc.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * @author rui
 * @create 2019-07-23 16:50
 */
public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //获得连接池对象
        DataSource dataSources = new ComboPooledDataSource();
        //获得链接对象
        Connection connection = dataSources.getConnection();
        //打印
        System.out.println(connection);
        //归还连接
        connection.close();
    }
}
