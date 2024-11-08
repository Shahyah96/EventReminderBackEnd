package team2umgc.eventreminder.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {

    //Generic Error Messages

    public static final String RESOURCE_NOT_FOUND_MSG = "Resource not found";

    public static final String SYSTEM_ERROR_MSG = "System error";

    public static final String REQUIRED_DATA_ELEMENT_MISSING_MSG = "Mandatory field missing";

    public static final String MESSAGE_NOTREADABLE_MSG = "Not readable";

    public static final String ILLEGAL_ARGUMENT_MSG = "Illegal argument";

    public static final String NULL_POINTER_MSG = "Null pointer exception";

    public static final String CONNECT_EXCEPTION_MSG = "Connection exception";

    public static final String USERNAME_ALREADY_EXISTS_MSG = "Username already exists";
    public static final String EMAIL_ALREADY_EXISTS_MSG = "Email already registered";
    public static final String MOBILE_ALREADY_EXISTS_MSG = "Mobile already registered";
    public static final String USER_REGISTRATION_SUCCESS_MSG = "User registration successful";
    public static final String USERNAME_OR_PASSWORD_MISSING_MSG = "Invalid credentials";
    public static final String LOGIN_SUCCESS_MSG = "Login successful";
}
