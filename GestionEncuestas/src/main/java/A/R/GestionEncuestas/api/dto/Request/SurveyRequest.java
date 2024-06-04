package A.R.GestionEncuestas.api.dto.Request;

import java.time.LocalDate;

import A.R.GestionEncuestas.domain.entities.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for survey request")
public class SurveyRequest {

    @Schema(description = "Title of the survey", example = "Survey of quality")                      
    @NotBlank(message = "The title of the survey is required")     
    @Size(max = 255, message = "The title of the survey must have a maximum of 100 characters")   
    private String survey_title;

    @Schema(description = "Survey description" )
    @NotBlank(message = "The description of survey is required")
    private String description;

    @Schema(description = "Status of the user")
    @NotBlank(message = "The status is required") 
    private boolean active;

    @Min(value = 1, message = "The ID of the creator must be greater than zero")
    @Max(value = 11, message = "The ID of creator the must not be longer than 11 characters")
    @NotNull(message = "The ID of creator is necessary,value cannot be less than 1")
    @Schema(description = "ID of the creator", example = "1")
    private User creator;

}
