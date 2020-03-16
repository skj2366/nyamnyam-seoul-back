package com.kjk.nyam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.kjk.nyam"})
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@PropertySource("config.properties")
public class NyamnyamSeoulApplication {

	public static void main(String[] args) {
		SpringApplication.run(NyamnyamSeoulApplication.class, args);
	}

}
