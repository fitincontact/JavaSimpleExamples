package com.fitincontact;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
}