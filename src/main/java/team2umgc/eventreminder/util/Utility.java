package team2umgc.eventreminder.util;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.Date;

public class Utility {

    public static String objectToJson(Object object) {

        return new Gson().toJson(object);
    }

    public static LocalDateTime getSystemDate() {
        return LocalDateTime.now();
    }

}
