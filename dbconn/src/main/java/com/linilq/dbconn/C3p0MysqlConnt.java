package com.linilq.dbconn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0MysqlConnt {


    public static void main(String[] args) {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setUser(Constants.username);
            dataSource.setPassword(Constants.password);
            dataSource.setJdbcUrl(Constants.url);
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setDataSourceName("c3p0");


            Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(Constants.sqlStr);

            ResultSet set = statement.executeQuery();

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

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
