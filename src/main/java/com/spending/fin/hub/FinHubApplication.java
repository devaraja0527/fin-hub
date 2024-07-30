package com.spending.fin.hub;

import com.spending.fin.hub.mock.FinHubMockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinHubApplication.class, args);

		new FinHubMockService().loadMockData();
	}

}
