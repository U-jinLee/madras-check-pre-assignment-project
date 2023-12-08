package com.example.madrascheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MadrasCheckPreAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MadrasCheckPreAssignmentApplication.class, args);
    }

}
