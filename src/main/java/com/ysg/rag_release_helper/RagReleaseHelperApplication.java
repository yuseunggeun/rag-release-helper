package com.ysg.rag_release_helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class RagReleaseHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(RagReleaseHelperApplication.class, args);
	}

}
