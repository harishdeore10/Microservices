package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Hello {

	@Autowired
	public RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	@ResponseBody
	public String input(@RequestBody String input) {
		String fileData = restTemplate.getForObject("https://storage.googleapis.com/user-test-data-1/Hello.txt",
				String.class);

		if (fileData.equals(input)) {
			return "True";
		} else {
			return "False";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Hello.class, args);
	}

}
