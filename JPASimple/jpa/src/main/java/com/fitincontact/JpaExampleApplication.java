package com.fitincontact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@SpringBootApplication
public class JpaExampleApplication {
    private static final Logger log = LoggerFactory.getLogger(JpaExampleApplication.class);

    public static void main(String... args) {
        log.info("start JPA Application");
        SpringApplication.run(JpaExampleApplication.class);
        log.info("finish JPA Application");
    }

    @Bean
    EvoInflectorLinkRelationProvider relProvider() {
        return new EvoInflectorLinkRelationProvider();
    }

    @Bean(name = "h2db")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:./data/h2db");

        dataSource.setUsername("sa");
        dataSource.setPassword("sa");

        Resource initSchema = new ClassPathResource("schema.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }
}