package com.fitincontact;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//localhost:8080/swagger-ui.html
@RestController
@Tag(name = "EmployeeController", description = "EmployeeController")
class EmployeeController {

    private final EmployeeRepository repository;
    private final EmployeeRepresentationModelAssembler assembler;

    EmployeeController(EmployeeRepository repository, EmployeeRepresentationModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Operation(
            summary = "findAll employees",
            description = "findAll employees"
    )
    @GetMapping("/employees")
    public ResponseEntity<CollectionModel<EntityModel<Employee>>> findAll() {
        return ResponseEntity.ok(
                this.assembler.toCollectionModel(this.repository.findAll()));
    }

    @Operation(
            summary = "findById employee",
            description = "findById employee"
    )
    @GetMapping("/employees/{id}")
    public ResponseEntity<EntityModel<Employee>> findOne(
            @Parameter(description = "id")
            @PathVariable
                    long id
    ) {

        return this.repository.findById(id)
                .map(this.assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "save employee",
            description = "save employee"
    )
    @PostMapping("/employee")
    public HttpStatus create(
            @Parameter(description = "EmployeeDTO")
            @RequestBody
                    EmployeeDTO dto
    ) {
        this.repository.save(new Employee(dto.getFirstName(), dto.getLastName(), dto.getRole()));
        return HttpStatus.OK;
    }
}