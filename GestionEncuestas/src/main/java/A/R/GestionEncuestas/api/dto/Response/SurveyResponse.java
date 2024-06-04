package A.R.GestionEncuestas.api.dto.Response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for survey response")
public class SurveyResponse {
    

    @Schema(description = "Questions of the survey")
    private List<QuestionResponse> questions;
    
}
