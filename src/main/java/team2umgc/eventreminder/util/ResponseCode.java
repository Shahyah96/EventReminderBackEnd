package team2umgc.eventreminder.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseCode {

    //Generic Error Codes

    public static final String SUCCESS = "00";

    public static final String FAILED = "01";

    public static final String METHOD_ARGUMENT_NOTVALID = "02";

    public static final String RESOURCE_NOT_FOUND = "03";

    public static final String ENTITY_NOT_FOUND = "04";

    public static final String MESSAGE_NOTREADABLE = "05";

    public static final String ILLEGAL_ARGUMENT = "06";

    public static final String NULL_POINTER = "07";

    public static final String CONNECT_EXCEPTION = "08";

}
