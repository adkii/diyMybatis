package com.mld.sqlSession;

import com.mld.config.MyConfig;
import com.mld.dao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyExecutor implements Executor {
    private MyConfig myConfig=new MyConfig();
    @Override
    public <T> T query(String sql, Object param) {
        Connection connection=getConnection();
        ResultSet resultSet=null;
        PreparedStatement pre=null;
        try {
           pre=connection.prepareStatement(sql);
           pre.setString(1,param.toString());
           resultSet=pre.executeQuery();
            User user=new User();
            while (resultSet.next()){
                user.setId(resultSet.getString(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
            return (T)user;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet!=null){
                    resultSet.close();
                }if(pre!=null){
                    pre.close();
                }if(connection!=null){
                    connection.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return null;
    }
    private Connection getConnection(){
        try{
            Connection connection=myConfig.build("MybatisConfig.xml");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
