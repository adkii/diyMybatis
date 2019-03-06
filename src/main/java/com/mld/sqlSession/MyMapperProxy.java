package com.mld.sqlSession;

import com.mld.config.Function;
import com.mld.config.MapperBean;
import com.mld.config.MyConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MyMapperProxy implements InvocationHandler {
    private MySqlSession mySqlSession;
    private MyConfig myConfig;

    public MyMapperProxy(MySqlSession mySqlSession, MyConfig myConfig) {
        this.mySqlSession = mySqlSession;
        this.myConfig = myConfig;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean mapperBean=myConfig.readMapper("UserMapper.xml");
        if(!method.getDeclaringClass().getName().equals(mapperBean.getInterfaceName())){
            return null;
        }
        List<Function> list=mapperBean.getFunctionList();
        if(null!=list || list.size()>0){
            for(Function function:list){
                if(method.getName().equals(function.getFuncName())){
                    return mySqlSession.selectOne(function.getSql(), String.valueOf(args[0]));
                }
            }
        }
        return null;
    }
}
