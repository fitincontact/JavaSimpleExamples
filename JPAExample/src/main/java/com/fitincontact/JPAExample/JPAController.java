package com.fitincontact.JPAExample;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Tag(name="Название контроллера", description="Описание контролера")
public class JPAController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/employees")
    @Operation(
            summary = "Получить потребителя",
            description = "Получить потребителя"
    )
    public List<CustomerDTO> all() {
        List<CustomerDTO> dtos = new ArrayList<>();
        List<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            dtos.add(new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName()));
        }
        return dtos;
    }
}