package br.com.salesmanagerweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableFeignClients
public class SalesManagerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerWebApplication.class, args);
	}

}
