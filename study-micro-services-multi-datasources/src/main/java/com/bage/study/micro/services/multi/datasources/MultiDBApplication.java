package com.bage.study.micro.services.multi.datasources;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackageClasses=MultiDBApplication.class)
public class MultiDBApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("jdbcTemplate1")
	JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("jdbcTemplate2")
	JdbcTemplate jdbcTemplate2;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MultiDBApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		System.out.println("-------------初始化数据库1-----------");
		initDb1();

		System.out.println("-------------初始化数据库2-----------");
		initDb2();

		System.out.println("-------------初始化结束------------");


	}

	private void initDb2() {
		jdbcTemplate2.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate2.execute("CREATE TABLE customers("
				+ "id SERIAL, "
				+ "first_name VARCHAR(255), "
				+ "last_name VARCHAR(255) "
				+ ")");

		// Split up the array of whole names into an array of first/last names
		List<String> names = Arrays.asList("John2 Woo2", "Jeff Dean", "Josh Bloch", "Josh Long");

		List<Object[]> params = new ArrayList<Object[]>(names.size());
		for(int i = 0;i < names.size(); i++) {
			params.add(names.get(i).split(" "));
		}
		// Uses JdbcTemplate's batchUpdate operation to bulk load data
		jdbcTemplate2.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", params );
	}

	private void initDb1() {
		jdbcTemplate1.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate1.execute("CREATE TABLE customers("
				+ "id SERIAL, "
				+ "first_name VARCHAR(255), "
				+ "last_name VARCHAR(255) "
				+ ")");

		// Split up the array of whole names into an array of first/last names
		List<String> names = Arrays.asList("John1 Woo1", "Jeff Dean", "Josh Bloch", "Josh Long");

		List<Object[]> params = new ArrayList<Object[]>(names.size());
		for(int i = 0;i < names.size(); i++) {
			params.add(names.get(i).split(" "));
		}
		// Uses JdbcTemplate's batchUpdate operation to bulk load data
		jdbcTemplate1.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", params );
	}

}