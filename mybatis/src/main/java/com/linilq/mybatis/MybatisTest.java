package com.linilq.mybatis;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linilq.mybatis.bean.SysUser;
import com.linilq.mybatis.dao.ChildSysUserDao;
import com.linilq.mybatis.dao.SysUserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    public static void main(String[] args) throws PropertyVetoException {

        xmlConfig();
//        javaConfig();
    }

    private static void xmlConfig() {
        String resource = "spring-mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        getDataFromSql(session);
    }

    private static void javaConfig() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(Constants.username);
        dataSource.setPassword(Constants.password);
        dataSource.setJdbcUrl(Constants.url);
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setDataSourceName("c3p0");


        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("linilqMybatis", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        configuration.addMapper(SysUserDao.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sessionFactory.openSession();
        getDataFromSql(session);

    }


    public static void getDataFromSql(SqlSession session) {

        ChildSysUserDao dao = session.getMapper(ChildSysUserDao.class);
        PageHelper.startPage(2, 2);
        List<SysUser> list = dao.getSysUser();
        long size = ((Page) list).getTotal();
        System.out.println("size = " + size + " " + list.toString());


        SysUser sysUser = dao.getSysUserByName("linilq");
        System.out.println(sysUser.toString());
    }
}
