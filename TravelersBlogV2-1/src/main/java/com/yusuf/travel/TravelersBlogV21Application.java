package com.yusuf.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TravelersBlogV21Application {

	public static void main(String[] args) {
		SpringApplication.run(TravelersBlogV21Application.class, args);
	}

}
