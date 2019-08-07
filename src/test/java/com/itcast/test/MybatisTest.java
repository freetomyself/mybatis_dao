package com.itcast.test;

/**
 * @program: day01_eesy_01mybatis--com.itcast.test
 * @author: WaHotDog 2019-08-04 13:08
 **/

import com.itcast.dao.IUserDao;
import com.itcast.dao.impl.UserDaoImpl;
import com.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 入门案例
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        //1引入配置文件
        InputStream inupt = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inupt);
        IUserDao userDao = new UserDaoImpl(factory);
        //5使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6释放资源
        inupt.close();
    }
}

