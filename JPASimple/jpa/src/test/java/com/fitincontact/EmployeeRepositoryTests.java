package com.fitincontact;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql(scripts = "/sql/insert.sql")
public class EmployeeRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testFindByLastName() {
        Employee employee = new Employee("first", "last", "role1");
        entityManager.persist(employee);

        List<Employee> findByLastName = repository.findByLastName(employee.getLastName());

        assertThat(findByLastName).extracting(Employee::getLastName).containsOnly(employee.getLastName());
    }
}