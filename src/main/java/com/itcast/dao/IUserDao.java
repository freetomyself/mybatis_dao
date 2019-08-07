package com.itcast.dao;

import com.itcast.domain.User;

import java.util.List;

/**
 * @program: day01_eesy_01mybatis--com.itcast.dao
 * @author: WaHotDog 2019-08-04 12:22
 **/


public interface IUserDao {

   public List<User> findAll();
}
