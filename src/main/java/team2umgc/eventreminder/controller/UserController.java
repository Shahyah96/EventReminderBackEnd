package team2umgc.eventreminder.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team2umgc.eventreminder.domain.request.LoginRequest;
import team2umgc.eventreminder.domain.request.RegisterUserRequest;
import team2umgc.eventreminder.domain.response.Response;
import team2umgc.eventreminder.service.UserService;
import team2umgc.eventreminder.util.EndPoint;
import team2umgc.eventreminder.util.Utility;
import team2umgc.eventreminder.validator.group.OrderedCheck;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = EndPoint.USER_REGISTER, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "User Registration", description = "User Registration Api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Object> userRegister(@Validated(OrderedCheck.class) @RequestBody RegisterUserRequest userRequest) {
        logger.debug("UserRegistration Request - {} ", Utility.objectToJson(userRequest));
        return userService.registerUser(userRequest);
    }

    @PostMapping(value = EndPoint.USER_LOGIN, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "User Login", description = "User login Api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Object> login(@Validated(OrderedCheck.class) @RequestBody LoginRequest loginRequest) {
        logger.debug("UserLogin Request - {} ", Utility.objectToJson(loginRequest));
        return userService.login(loginRequest);
    }

    @GetMapping(value = EndPoint.HELLO_WORLD)
    public String HelloWorld() throws Exception {
        return "Hello World!";
    }
}
