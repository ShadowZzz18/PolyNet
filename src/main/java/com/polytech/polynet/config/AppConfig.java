package com.polytech.polynet.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polynet.business.TaskService;
import com.polytech.polynet.business.TaskServiceImpl;
import com.polytech.polynet.business.AccountService;
import com.polytech.polynet.business.AccountServiceImpl;
import com.polytech.polynet.repository.JpaTaskRepository;
import com.polytech.polynet.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    TaskRepository storyRepository() {
        return new JpaTaskRepository(datasource());
    }

    @Bean
    TaskService feedService() {
        return new TaskServiceImpl(storyRepository());
    }

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://mysql-tristanpuaux.alwaysdata.net:3306/tristanpuaux_tasklist?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
        dataSource.setUser("177084_root");
        dataSource.setPassword("root_2019");
        dataSource.setDatabaseName("tristanpuaux_tasklist");
        return dataSource;
    }

    @Bean
    AccountService publicationService() {
        return new AccountServiceImpl(storyRepository());
    }
}
