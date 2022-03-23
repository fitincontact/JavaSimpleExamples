package com.fitincontact.JPAExample;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность потребителя")
public class CustomerDTO {
    @Schema(description = "Customer id")
    private final Long id;
    @Schema(description = "Customer firstName")
    private final String firstName;
    @Schema(description = "Customer lastName")
    private final String lastName;

    public CustomerDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}