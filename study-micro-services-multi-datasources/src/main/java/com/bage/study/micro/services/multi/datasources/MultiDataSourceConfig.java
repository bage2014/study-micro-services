package com.bage.study.micro.services.multi.datasources;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MultiDataSourceConfig {

    @Bean(name = "multidb1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource multidb1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "multidb2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource multidb2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "jdbcTemplate1")
    public JdbcTemplate jdbcTemplate1(@Qualifier("multidb1") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "jdbcTemplate2")
    public JdbcTemplate jdbcTemplate2(@Qualifier("multidb2") DataSource dataSource) {
        return new JdbcTemplate(dataSource);

    }
}
