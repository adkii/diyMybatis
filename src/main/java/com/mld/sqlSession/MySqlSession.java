package com.mld.sqlSession;


import com.mld.config.MyConfig;

import java.lang.reflect.Proxy;

public class MySqlSession {
    private Executor executor=new MyExecutor();
    private MyConfig myConfig=new MyConfig();
    public <T> T selectOne(String sql,Object param){
        return executor.query(sql,param);
    }
    @SuppressWarnings("")
    public <T> T getMapper(Class<T> tClass){
        //动态代理的调用
        return (T)Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass},new MyMapperProxy(this,myConfig));
    }
}
