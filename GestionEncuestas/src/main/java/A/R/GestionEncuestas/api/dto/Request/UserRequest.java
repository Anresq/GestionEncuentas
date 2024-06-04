package A.R.GestionEncuestas.api.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @Schema(description = "Name of the user", example = "Ana Restrepo") 
    @NotBlank(message = "The name is required") 
    @Size(max = 100, message = "The Name must have a maximum of 100 characters") 
    private String name;

    @Schema(description = "Email of the user", example = "Anar@example.com") 
    @NotBlank(message = "The email is required") 
    @Size(max = 255, message = "The email must have a maximum of 255 characters") 
    private String email;

    @Schema(description = "Password of the user") 
    @NotBlank(message = "The password is required") 
    private String password;


    @Schema(description = "Status of the user")
    @NotBlank(message = "The status is required") 
    private boolean active;

}
