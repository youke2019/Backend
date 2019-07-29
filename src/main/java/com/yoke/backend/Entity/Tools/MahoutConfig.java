package com.yoke.backend.Entity.Tools;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
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
        dataSource.setDatabaseName("yoketest");
        return dataSource;
    }

    @Bean(value = "mysqlDataModel")
    public DataModel getMysqlDataModel(){
        DataModel dataModel=new MySQLJDBCDataModel(getDataSource(),"course_evaluate","ID","course_id_int","course_evaluate_point","course_evaluate_time");
        return dataModel;
    }

}

