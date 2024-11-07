package team2umgc.eventreminder.domain.response;

import lombok.Data;

@Data
public class Response {
    private String status;
    private String message;
    private Object data;
}
