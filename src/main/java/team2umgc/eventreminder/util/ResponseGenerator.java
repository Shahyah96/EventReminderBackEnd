package team2umgc.eventreminder.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import team2umgc.eventreminder.domain.response.Response;

import java.util.Locale;

@Component
public class ResponseGenerator {


    private static final Logger logger = LoggerFactory.getLogger(ResponseGenerator.class);

    public ResponseEntity<Object> generateResponse(String responseCode, String message) {
        Response response = new Response();
        response.setStatus(responseCode);
        response.setMessage(message);

        logger.debug(responseCode + "-" + message + "\n");
        logger.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Object> generateResponse(Object data, String responseCode, String message) {
        Response response = new Response();
        response.setStatus(responseCode);
        response.setMessage(message);
        response.setData(data);

        logger.debug(responseCode + "-" + message + "\n");
        logger.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
