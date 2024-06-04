package A.R.GestionEncuestas.api.dto.Response.basic;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for survey basic response")
public class SurveyBasicResponse {

    @Schema(description = "ID of the survey", example = "1")
    private Long id_Survey;
    @Schema(
    description = "Title of the survey", example = "Survey of quality") 
    private String survey_title;
    @Schema(description = "Survey description" )
    private String description;
    @Schema(description = "Creation date of the survey")
    private LocalDate creation_date;
    @Schema(description = "Status of the user")
    private boolean active;

}
