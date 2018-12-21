package com.bage.study.micro.services.organization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses=Application.class)
@EnableCaching
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void run(String... strings) throws Exception {

        log.info("-------------初始化数据库-----------");

        jdbcTemplate.execute("DROP TABLE users IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE users(" 
        		+ "id SERIAL, "
                + "name VARCHAR(255)"
                + ")");

        // Split up the array of whole names into an array of first/last names
        List<String> names = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long");

        List<Object[]> params = new ArrayList<Object[]>(names.size());
        for(int i = 0;i < names.size(); i++) {
        	params.add(new Object[] {names.get(i)});
        }
		// Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO users(name) VALUES (?)", params );

        log.info("-------------初始化结束------------");
        
    }
}
