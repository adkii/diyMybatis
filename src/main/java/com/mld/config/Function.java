package com.mld.config;

public class Function {
    public String getSqltype() {
        return sqltype;
    }

    public void setSqltype(String sqltype) {
        this.sqltype = sqltype;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object getResultType() {
        return resultType;
    }

    public void setResultType(Object resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    private String sqltype;
    private String funcName;
    private String sql;
    private Object resultType;
    private String parameterType;
}
