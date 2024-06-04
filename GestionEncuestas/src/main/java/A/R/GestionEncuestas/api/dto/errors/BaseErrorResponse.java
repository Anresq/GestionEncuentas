package A.R.GestionEncuestas.api.dto.errors;


import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "error structure")
public class BaseErrorResponse implements Serializable {
    private String status;
    private Integer code;
    private String message;
}
