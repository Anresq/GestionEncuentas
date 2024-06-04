package A.R.GestionEncuestas.api.dto.Request.Update;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for question update request")
public class QuestionUpdateResponse {

    @Schema(description = "Question", example = "The question exists?") 
    @NotBlank(message = "The question is required") 
    private String text;
    
}
