package com.rui.jdbc.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author rui
 * @create 2019-07-23 19:24
 */
public class Demo3 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            //获得连接
            connection = JDBCUtils.getConnection();
            //定义sql
            String sql = "insert into student values('5',?,?)";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, 23);
            pstm.setInt(2, 34);
            int i = pstm.executeUpdate();
            if (i > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放走远
            JDBCUtils.close(pstm, connection);
        }

    }
}
