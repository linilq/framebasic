package com.linilq.dbconn;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MysqlConnect {

    static class MyTest{
        MyTest(){
            System.out.println("Mytest **********");
        }
    }

    public static void main(String[] args) {

        Connection connection = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            new Driver();
            connection = DriverManager.getConnection(Constants.url, Constants.username, Constants.password);
            PreparedStatement psta = connection.prepareStatement(Constants.sqlStr);
            ResultSet set = psta.executeQuery();

            while (set.next()) {
                Integer id = set.getInt(set.findColumn("id"));
                String userName = set.getString(set.findColumn("userName"));
                String password1 = set.getString(set.findColumn("password"));
                String createBy = set.getString(set.findColumn("createBy"));
                String updateBy = set.getString(set.findColumn("updateBy"));
                String createTime = set.getString(set.findColumn("createTime"));
                String updateTime = set.getString(set.findColumn("updateTime"));

                System.out.println(id);
                System.out.println(userName);
                System.out.println(password1);
                System.out.println(createBy);
                System.out.println(updateBy);
                System.out.println(createTime);
                System.out.println(updateTime);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


    }
}
