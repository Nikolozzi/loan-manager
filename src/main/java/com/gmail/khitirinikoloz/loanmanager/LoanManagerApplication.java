package com.gmail.khitirinikoloz.loanmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LoanManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagerApplication.class, args);
	}

}
