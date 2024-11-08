package team2umgc.eventreminder.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team2umgc.eventreminder.domain.request.LoginRequest;
import team2umgc.eventreminder.domain.request.RegisterUserRequest;
import team2umgc.eventreminder.entity.UserAccount;
import team2umgc.eventreminder.repositories.UserAccountRepository;
import team2umgc.eventreminder.service.UserService;
import team2umgc.eventreminder.util.ResponseCode;
import team2umgc.eventreminder.util.ResponseGenerator;
import team2umgc.eventreminder.util.ResponseMessage;
import team2umgc.eventreminder.util.Utility;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ResponseGenerator responseGenerator;
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public ResponseEntity<Object> registerUser(RegisterUserRequest registerUserRequest) {
        // Check if the username already exists
        if (userAccountRepository.findByUserName(registerUserRequest.getUsername()).isPresent()) {
            logger.info("User registered fail with username exist: {}", registerUserRequest.getEmail());
            return responseGenerator.generateResponse(ResponseCode.FAILED, ResponseMessage.USERNAME_ALREADY_EXISTS_MSG);
        }

        // Check if the email already exists
        if (userAccountRepository.findByEmail(registerUserRequest.getEmail()).isPresent()) {
            logger.info("User registered fail with email exist: {}", registerUserRequest.getEmail());
            return responseGenerator.generateResponse(ResponseCode.FAILED, ResponseMessage.EMAIL_ALREADY_EXISTS_MSG);
        }

        // Check if the mobile number already exists
        if (userAccountRepository.findUserByMobileNumber(registerUserRequest.getMobile()).isPresent()) {
            logger.info("User registered fail with mobile number exist: {}", registerUserRequest.getEmail());
            return responseGenerator.generateResponse(ResponseCode.FAILED, ResponseMessage.MOBILE_ALREADY_EXISTS_MSG);
        }

        // Create new UserAccount if no conflicts
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(registerUserRequest.getUsername());
        userAccount.setEmail(registerUserRequest.getEmail());
        userAccount.setPassword(registerUserRequest.getPassword());
        userAccount.setMobileNumber(registerUserRequest.getMobile());
        userAccount.setCreatedDate(Utility.getSystemDate());
        userAccount.setLastModifiedDate(Utility.getSystemDate());

        userAccountRepository.save(userAccount);

        // Log successful registration
        logger.info("User registered successfully with email: {}", registerUserRequest.getEmail());

        return responseGenerator.generateResponse(ResponseCode.SUCCESS, ResponseMessage.USER_REGISTRATION_SUCCESS_MSG);
    }

    @Override
    public ResponseEntity<Object> login(LoginRequest loginRequest) {
        Optional<UserAccount> userAccount = userAccountRepository.findByUserNameOrEmail(loginRequest.getUsernameOrEmail(), loginRequest.getUsernameOrEmail());
        // Check if user account exists and validate the password
        if (userAccount.isPresent() && userAccount.get().getPassword().equals(loginRequest.getPassword())) {
            logger.info("User login successfully with username/email: {}", loginRequest.getUsernameOrEmail());
            return responseGenerator.generateResponse(ResponseCode.SUCCESS, ResponseMessage.LOGIN_SUCCESS_MSG);
        } else {
            logger.info("User login failed with username/email: {} (incorrect credentials)", loginRequest.getUsernameOrEmail());
            return responseGenerator.generateResponse(ResponseCode.FAILED, ResponseMessage.USERNAME_OR_PASSWORD_MISSING_MSG);
        }
    }

}
