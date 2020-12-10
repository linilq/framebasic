package com.linilq.mybatis;


import com.linilq.mybatis.bean.SysUser;
import com.linilq.mybatis.dao.SysUserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.beans.PropertyVetoException;

public class MybatisTest {


    public static void main(String[] args) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(Constants.username);
        dataSource.setPassword(Constants.password);
        dataSource.setJdbcUrl(Constants.url);
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setDataSourceName("c3p0");


        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("linilqMybatis", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        configuration.addMapper(SysUserDao.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession session = sessionFactory.openSession();
        SysUser sysUser = session.selectOne("com.linilq.mybatis.dao.SysUserDao.getSysUserByName", "linilq");

        System.out.println(sysUser.toString());
    }
}
