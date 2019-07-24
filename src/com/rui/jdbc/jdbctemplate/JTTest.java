package com.rui.jdbc.jdbctemplate;

import com.rui.jdbc.domain.Emp;
import com.rui.jdbc.druid.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rui
 * @create 2019-07-24 14:03
 */
public class JTTest {
    JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    }

    /**
     * 更新
     */
    @Test
    public void test1() {
        int update = jdbcTemplate.update("update student set age=21 where name ='1'");
        System.out.println(update);
    }

    /**
     * 添加记录
     */
    @Test
    public void test2() {
        String sql = "insert into student values(?,?,?)";
        int update = jdbcTemplate.update(sql, "6", 6, 6);
        System.out.println(update);
    }

    /**
     * 删除
     */
    @Test
    public void test3() {
        String sql = "delete  from student where name= ? ";
        int update = jdbcTemplate.update(sql, "6");
        System.out.println(update);
    }

    /**
     * 查询
     * 注意：queryForMap查询的结果集只能为1
     */
    @Test
    public void test4() {
        String sql = "select * from student where age=?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 23);
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());

        }
    }

    /**
     * queryForList查询
     */
    @Test
    public void test5() {
        String sql = "select * from student where age=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, 100);
        System.out.println(maps);

    }

    @Test
    public void test6_1() {
        String sql = "select * from student";
        List<Emp> list = jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                emp.setName(resultSet.getString("name"));
                emp.setAge(resultSet.getInt(2));
                emp.setBorn(resultSet.getInt(3));
                return emp;
            }
        });
        System.out.println(list);

    }

    @Test
    public void test6_2() {
        String sql = "select * from student";
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : query
        ) {
            System.out.println(emp);
        }
    }

    /**
     * 查询总计录数
     */
    @Test
    public void test7() {
        String sql = "SELECT COUNT(*) FROM STUDENT ";
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(aLong);

    }
}
