package team2umgc.eventreminder.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2umgc.eventreminder.validator.group.FirstValidation;

@Data
@NoArgsConstructor
public class RegisterUserRequest {
    @NotBlank(message = "Username cannot be empty", groups = FirstValidation.class)
    private String username;
    @NotBlank(message = "Password cannot be empty", groups = FirstValidation.class)
    private String password;
    @NotBlank(message = "Mobile cannot be empty", groups = FirstValidation.class)
    private String mobile;
    @NotBlank(message = "Email cannot be empty", groups = FirstValidation.class)
    private String email;
}
