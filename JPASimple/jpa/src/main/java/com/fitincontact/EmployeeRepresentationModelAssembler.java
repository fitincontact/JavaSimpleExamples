package com.fitincontact;

import org.springframework.stereotype.Component;

@Component
class EmployeeRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Employee> {

    EmployeeRepresentationModelAssembler() {
        super(EmployeeController.class);
    }
}
