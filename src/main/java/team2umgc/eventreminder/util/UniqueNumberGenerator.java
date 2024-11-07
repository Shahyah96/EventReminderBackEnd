package team2umgc.eventreminder.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UniqueNumberGenerator {

    private static final SecureRandom secureRandom;

    static {
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to initialize SecureRandom.", e);
        }
    }

    public static synchronized String generateUniqueNumber() {
//        int i = (int) (new Date().getTime());
        String randomNumber = generateRandomNumber();
//        return i + randomNumber;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        return simpleDateFormat.format(new Date()) + randomNumber;
    }

    private static String generateRandomNumber() {
        return String.format("%02d", secureRandom.nextInt(100)); // 2-digit random number
    }

}
