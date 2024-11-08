package team2umgc.eventreminder.service;

import org.springframework.http.ResponseEntity;
import team2umgc.eventreminder.domain.request.LoginRequest;
import team2umgc.eventreminder.domain.request.RegisterUserRequest;
import team2umgc.eventreminder.domain.response.Response;

public interface UserService {
    ResponseEntity<Object> registerUser(RegisterUserRequest registerUserRequest);
    ResponseEntity<Object> login(LoginRequest loginRequest);
}
