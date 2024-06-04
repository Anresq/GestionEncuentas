package A.R.GestionEncuestas.api.dto.Request;


import A.R.GestionEncuestas.api.dto.Request.Update.QuestionUpdateResponse;
import A.R.GestionEncuestas.util.enums.TypeQuestion;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
public class QuestionRequest extends QuestionUpdateResponse{

    @NotBlank(message = "The name is required") 
    private TypeQuestion typeQuestion;

    @Schema(description = "Status of the user")
    @NotBlank(message = "The status is required") 
    private boolean active;
}
