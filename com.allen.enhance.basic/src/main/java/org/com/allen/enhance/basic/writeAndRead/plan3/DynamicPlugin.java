package org.com.allen.enhance.basic.writeAndRead.plan3;

import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.mysql.jdbc.Connection;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class DynamicPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Connection conn = (Connection) invocation.getArgs()[0];
        if(conn instanceof org.com.allen.enhance.basic.writeAndRead.plan3.ConnectionProxy ) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MappedStatement mappedStatement = null;
            if (statementHandler instanceof RoutingStatementHandler) {
                StatementHandler delegate = (StatementHandler) ReflectionUtils
                        .getFieldValue(statementHandler, "delegate");
                mappedStatement = (MappedStatement) ReflectionUtils.getFieldValue(
                        delegate, "mappedStatement");
            } else {
                mappedStatement = (MappedStatement) ReflectionUtils.getFieldValue(
                        statementHandler, "mappedStatement");
            }
            String key = AbstractDynamicDataSourceProxy.WRITE;

            if(mappedStatement.getSqlCommandType() == SqlCommandType.SELECT){
                key = AbstractDynamicDataSourceProxy.READ;
            }else{
                key = AbstractDynamicDataSourceProxy.WRITE;
            }

            ConnectionProxy connectionProxy = (ConnectionProxy)conn;
            connectionProxy.getTargetConnection(key);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties arg0) {
        // TODO Auto-generated method stub

    }

}
