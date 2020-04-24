package com.baidu.server1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "my1DataSource")
    @Qualifier("my1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.my1")
    public DataSource rfdbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "my1JdbcTemplate")
    public JdbcTemplate rfdbJdbcTemplate(
            @Qualifier("my1DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "my2DataSource")
    @Qualifier("my2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.my2")
    public DataSource syrkDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "my2JdbcTemplate")
    public JdbcTemplate my2JdbcTemplate(
            @Qualifier("my2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}