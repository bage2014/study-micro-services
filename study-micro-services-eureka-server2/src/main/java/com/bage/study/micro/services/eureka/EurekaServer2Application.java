package com.bage.study.micro.services.eureka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer2Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServer2Application.class, args);
	}

}