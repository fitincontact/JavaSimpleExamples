package com.fitincontact.JPAExample;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql(scripts = "/sql/insert.sql")
public class CustomerRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository repository;

    @Test
    public void testFindByLastName() {
        Customer customer = new Customer("first", "last");
        entityManager.persist(customer);

        List<Customer> findByLastName = repository.findByLastName(customer.getLastName());

        assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
    }
}