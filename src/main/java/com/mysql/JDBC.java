package com.mysql;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

//        Statement stmt = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("select id, grade, name, gender from students where gender=? and grade=?");
        ps.setObject(1, 1);
        ps.setObject(2, 3);
        ResultSet res = ps.executeQuery();
//        ResultSet res = stmt.executeQuery("select id, grade, name, gender from students where gender=1");

        while (res.next()) {
            long id = res.getLong(1);
            long grade = res.getLong(2);
            String name = res.getString(3);
            int gender = res.getInt(4);

            System.out.println("id=" + id + "grade=" + grade + "name=" + name + "gender=" + gender);
        }

        PreparedStatement insertPs = conn.prepareStatement("insert into students (id, name, gender, grade, score) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        insertPs.setObject(1, 90909);
        insertPs.setObject(2, "esdf");
        insertPs.setObject(3, 1);
        insertPs.setObject(4, 3);
        insertPs.setObject(5, 100);

        int insertRes = insertPs.executeUpdate();
        ResultSet r = insertPs.getGeneratedKeys();

        while (r.next()) {
            long id = r.getLong(1);
            System.out.println("key=" + id);
        }

        PreparedStatement updatePs = conn.prepareStatement("update students set score=? where name=?");
        updatePs.setObject(1, 233);
        updatePs.setObject(2, "Bob");

        int n = updatePs.executeUpdate();

        System.out.println("update lines=" + n);

        PreparedStatement deletePs = conn.prepareStatement("delete from students where id=?");

        deletePs.setObject(1, 888);
        int c = deletePs.executeUpdate();

        System.out.println("delete line =" + c);

        System.out.println(insertRes);

        try {
            conn.setAutoCommit(false);
            downScore(conn, "小明", 10);
            upScore(conn, "小红", 100);
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);

        }


        PreparedStatement batchPs = conn.prepareStatement("insert into students (name, gender, grade, score) values (?,?,?,?)");

        for (int i = 0; i < 100; i++) {
            batchPs.setObject(1, "name" + i);
            batchPs.setObject(2, i % 2);
            batchPs.setObject(3, i);
            batchPs.setObject(4, i+100);
            batchPs.addBatch();
        }

        int[] ns = batchPs.executeBatch();
        for (int s : ns) {
            System.out.println(s+"inserted.");
        }


        res.close();
        ps.close();
        conn.close();
    }

    static void downScore(Connection conn, String name, int score) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update students set score=? where name=?");
        ps.setObject(1, score);
        ps.setObject(2, name);
        ps.executeUpdate();
    }

    static void upScore(Connection conn, String name, int score) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update students set score=? where name=?");
        ps.setObject(1, score);
        ps.setObject(2, name);
        ps.executeUpdate();
    }

}
