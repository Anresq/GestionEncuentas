package A.R.GestionEncuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import A.R.GestionEncuestas.api.dto.Request.UserRequest;
import A.R.GestionEncuestas.api.dto.Response.UserResponse;
import A.R.GestionEncuestas.infraestructure.abstract_service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService iUserService;

    @Operation(
        summary = "Show all users",
        description = "Show Users in a list, is configured to display 10 users per page"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @Parameter(description = "Page number", example = "1") 
            @RequestParam(defaultValue = "1") int page,
            @Parameter(description = "Number of items per page", example = "10") 
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iUserService.getAll(page - 1, size));
    }

    @Operation(
        summary = "Show one user by id",
        description = "Shows the user by the ID sent or requested")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
        })
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iUserService.getById(id));
    }

    @Operation(
        summary = "Create a new user",
        description = "create a new user by entering the required data"
    ) //SWAGGER
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.iUserService.create(request));
    }

    @Operation(
        summary = "Update user by ID",
        description = "Update an existing user "
    ) //SWAGGER
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PutMapping
    public ResponseEntity<UserResponse> update(
            @Validated @RequestBody UserRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iUserService.update(request, id));
    }

}
