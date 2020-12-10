package com.linilq.dbconn;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidMysqlConnect {


    public static void main(String[] args) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(Constants.username);
        dataSource.setPassword(Constants.password);
        dataSource.setUrl(Constants.url);

        try {
            DruidPooledConnection connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement(Constants.sqlStr);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
