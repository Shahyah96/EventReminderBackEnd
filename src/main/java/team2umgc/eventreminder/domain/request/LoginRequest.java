package team2umgc.eventreminder.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import team2umgc.eventreminder.validator.group.FirstValidation;

@Data
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Username cannot be empty", groups = FirstValidation.class)
    private String usernameOrEmail;
    @NotBlank(message = "Password cannot be empty", groups = FirstValidation.class)
    private String password;
}
