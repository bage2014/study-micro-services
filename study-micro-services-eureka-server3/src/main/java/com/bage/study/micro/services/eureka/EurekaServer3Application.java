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
public class EurekaServer3Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServer3Application.class, args);
	}

}