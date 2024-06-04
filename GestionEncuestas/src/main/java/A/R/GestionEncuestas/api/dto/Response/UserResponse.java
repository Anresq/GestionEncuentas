package A.R.GestionEncuestas.api.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for course request")
public class UserResponse {
    @Schema(description = "ID of the user", example = "1")
    private long id_User;
    @Schema(description = "Name of the user")
    private String name;
    @Schema(description = "Email of the user") 
    private String email; 
    @Schema(description = "Status of the user") 
    private boolean active;
}
