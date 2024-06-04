package A.R.GestionEncuestas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import A.R.GestionEncuestas.api.dto.Request.SurveyRequest;
import A.R.GestionEncuestas.api.dto.Response.SurveyResponse;
import A.R.GestionEncuestas.api.dto.Response.basic.SurveyBasicResponse;
import A.R.GestionEncuestas.infraestructure.abstract_service.ISurveyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/survey")
@AllArgsConstructor
public class SurveyController {

    @Autowired
    private final ISurveyService iSurveyService;

     @Operation(
        summary = "Show all surveys",
        description = "Show survey in a list, is configured to display 10 users per page")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    
    @GetMapping
    public ResponseEntity<Page<SurveyBasicResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iSurveyService.getAll(page - 1, size));
    }

    @Operation(
        summary = "Show one survey by id",
        description = "Shows the survey by the ID sent or requested")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<SurveyResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iSurveyService.getById(id));
    }

    @Operation(
        summary = "Create a new survey",
        description = "create a new survey by entering the required data")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
        @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<SurveyBasicResponse> create(
            @Validated @RequestBody SurveyRequest request) {
        return ResponseEntity.ok(this.iSurveyService.create(request));
    }
}