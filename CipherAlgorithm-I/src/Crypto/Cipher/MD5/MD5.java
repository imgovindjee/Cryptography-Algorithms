package Crypto.Cipher.MD5;

import org.jetbrains.annotations.Nullable;

import java.security.MessageDigest;

public class MD5 {

    public static @Nullable String hash (String message) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = messageDigest.digest(message.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte hb : hashBytes) {
                sb.append(String.format("%02x", hb));
            }
            return sb.toString();
        } catch (Exception exception) {
            System.out.println("[MD5] Error Occurred while \"hash()\" of the message -> "+exception.getMessage());
        }

        return null;
    }
}
