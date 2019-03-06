package com.mld.test;

import com.mld.config.MyConfig;
import com.mld.dao.User;
import com.mld.dao.mapper.UserMapper;
import com.mld.sqlSession.MySqlSession;

public class TestFirst {
    public static void main(String[] args){
        MySqlSession mySqlSession=new MySqlSession();
        UserMapper userMapper=mySqlSession.getMapper(UserMapper.class);
        User user=userMapper.getUserById("1");
        System.out.println(user.toString());
    }
}
