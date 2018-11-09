package com.liu.userserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class UserserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserverApplication.class, args);
	}

	@Value("${test}")
	String test;

	@RequestMapping(value = "/hi")
	public String hi(){
		return test;
	}
}
