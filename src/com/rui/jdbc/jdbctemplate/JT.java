package com.rui.jdbc.jdbctemplate;

import com.rui.jdbc.druid.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author rui
 * @create 2019-07-24 11:39
 */
public class JT {
    public static void main(String[] args) {

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update student set name='小明' where name=?";
        int count = template.update(sql, "3");
        System.out.println(count);
    }
}
