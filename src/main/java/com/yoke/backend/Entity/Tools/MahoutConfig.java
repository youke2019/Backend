package com.yoke.backend.Entity.Tools;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 **/
@Configuration
public class MahoutConfig {

    private MysqlDataSource getDataSource(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setServerName("127.0.0.1");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("yoke");
        return dataSource;
    }

    @Bean(value = "mysqlDataModel")
    public JDBCDataModel getMysqlDataModel() throws Exception{
        JDBCDataModel jdbcDataModel=new MySQLJDBCDataModel(getDataSource(),"course_recommend_data_model","user_id","lcourse_id","evaluate_point","evaluate_time");
        return jdbcDataModel;
    }

}

