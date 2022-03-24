package com.fitincontact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader {
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner init(EmployeeRepository repository) {

        return args -> {
            repository.save(new Employee("David", "Fitin1", "son"));
            repository.save(new Employee("Seva", "Fitin2", "father"));

            // fetch all Employees
            log.info("Employees found with findAll():");
            log.info("-------------------------------");
            for (Employee employee : repository.findAll()) {
                log.info(employee.toString());
            }
            log.info("");

            // fetch an individual Employee by ID
            Employee employee = repository.findById(1L).orElse(null);
            log.info("Employee found with findById(1L):");
            log.info("--------------------------------");
            log.info(employee == null ? "" : employee.toString());
            log.info("");

            // fetch Employees by last name
            log.info("Employee found with findByLastName('Fitin'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Fitin").forEach(fitin -> {
                log.info(fitin.toString());
            });

            log.info("");
        };
    }
}