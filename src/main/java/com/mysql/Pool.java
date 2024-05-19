package com.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pool {
    public static void main(String[] args) throws SQLException {
        HikariConfig config = new HikariConfig();

        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123";


        config.setJdbcUrl(JDBC_URL);
        config.setUsername(JDBC_USER);
        config.setPassword(JDBC_PASSWORD);

        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10

        DataSource ds = new HikariDataSource(config);

        Connection conn = ds.getConnection();

        PreparedStatement ps = conn.prepareStatement("select id, grade, name, gender from students where gender=? and grade=?");
        ps.setObject(1, 1);
        ps.setObject(2, 3);
        ResultSet res = ps.executeQuery();

        while (res.next()) {
            long id = res.getLong(1);
            long grade = res.getLong(2);
            String name = res.getString(3);
            int gender = res.getInt(4);

            System.out.println("id=" + id + "grade=" + grade + "name=" + name + "gender=" + gender);
        }

        conn.close();


    }
}
