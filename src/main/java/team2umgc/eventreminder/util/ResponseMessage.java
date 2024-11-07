package team2umgc.eventreminder.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {

    //Generic Error Messages

    public static final String RESOURCE_NOT_FOUND_MSG = "val.resource.not.found";

    public static final String SYSTEM_ERROR_MSG = "val.system.error";

    public static final String REQUIRED_DATA_ELEMENT_MISSING_MSG = "val.mandatory.fields.missing";

    public static final String MESSAGE_NOTREADABLE_MSG = "val.message.notreadable";

    public static final String ILLEGAL_ARGUMENT_MSG = "val.illegal.argument";

    public static final String NULL_POINTER_MSG = "val.null.pointer";

    public static final String CONNECT_EXCEPTION_MSG = "val.connect.exception";


}
