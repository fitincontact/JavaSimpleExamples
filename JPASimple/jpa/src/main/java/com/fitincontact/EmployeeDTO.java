package com.fitincontact;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Schema(description = "EmployeeDTO")
@Getter
@Setter
public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "firstName", example = "Tom")
    private String firstName;
    @Schema(description = "lastName", example = "Soyer")
    private String lastName;
    @Schema(description = "role", example = "kind")
    private String role;
}