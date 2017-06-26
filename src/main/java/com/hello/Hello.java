package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class Hello {

	@RequestMapping(value="/")
	@ResponseBody
	public String sayHello(){
		return "Welcome to Spring Boot with Goocle Cloud Platform .";
	}
	
	public static void main(String [] args){
		SpringApplication.run(Hello.class, args);
	}
	
}
