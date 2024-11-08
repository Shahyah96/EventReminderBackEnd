package team2umgc.eventreminder.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import team2umgc.eventreminder.domain.FieldValidationError;
import team2umgc.eventreminder.util.ResponseCode;
import team2umgc.eventreminder.util.ResponseGenerator;
import team2umgc.eventreminder.util.ResponseMessage;
import team2umgc.eventreminder.util.Utility;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ResponseGenerator responseGenerator;

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, Locale lang) {
        List<FieldValidationError> fieldValidationErrorList = new ArrayList<>();

        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
        if (objectError instanceof FieldError) {
            ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
                String fieldName = fieldError.getField();
                String errorMessage = fieldError.getDefaultMessage();
                fieldValidationErrorList.add(new FieldValidationError(fieldName, errorMessage));
            });
        }

        logger.error("Field error - {} ", Utility.objectToJson(fieldValidationErrorList));

        return responseGenerator.generateResponse(fieldValidationErrorList, ResponseCode.METHOD_ARGUMENT_NOTVALID, ResponseMessage.REQUIRED_DATA_ELEMENT_MISSING_MSG);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> handleNoHandlerFoundException(NoHandlerFoundException e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(ResponseCode.RESOURCE_NOT_FOUND, ResponseMessage.RESOURCE_NOT_FOUND_MSG);
    }

    @ExceptionHandler(ObjectNotFondException.class)
    public ResponseEntity<?> handleObjectNotFondException(ObjectNotFondException e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(ResponseCode.ENTITY_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> handleCommonException(CommonException e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(ResponseCode.MESSAGE_NOTREADABLE, ResponseMessage.MESSAGE_NOTREADABLE_MSG);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(ResponseCode.ILLEGAL_ARGUMENT, ResponseMessage.ILLEGAL_ARGUMENT_MSG);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(ResponseCode.NULL_POINTER, ResponseMessage.NULL_POINTER_MSG);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<?> handleConnectException(ConnectException e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(ResponseCode.CONNECT_EXCEPTION, ResponseMessage.CONNECT_EXCEPTION_MSG);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        logger.error(e.toString());
        return responseGenerator.generateResponse(ResponseCode.FAILED, ResponseMessage.SYSTEM_ERROR_MSG);
    }

}
