package com.rakesh.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.rakesh.crud.audit.AuditorAwareImpl;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class EmployeeCrudWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudWebAppApplication.class, args);
	}

	@Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

}
