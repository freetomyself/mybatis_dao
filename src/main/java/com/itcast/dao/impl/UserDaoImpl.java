package com.itcast.dao.impl;

import com.itcast.dao.IUserDao;
import com.itcast.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @program: day01_eesy_03mybatis_dao--com.itcast.dao.impl
 * @author: WaHotDog 2019-08-05 16:43
 **/


public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }
    public List<User> findAll() {
        //1.使用工厂创建sqlSessionFacatiry
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有信息
        List<User> users = session.selectList("com.itcast.dao.IUserDao.findAll");
        session.close();
        //返回查询结果
        return users;
    }
}
