package Crypto.Cipher.SHA;

import org.jetbrains.annotations.Nullable;

import java.security.MessageDigest;

public class SHA {

    public static @Nullable String hash (String message) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = messageDigest.digest(message.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte hb : hashBytes) {
                sb.append(String.format("%02x", hb));
            }
            return sb.toString();
        } catch (Exception exception) {
            System.out.println("[SHA] Error Encountered while \"hashing -> hash()\" the Data --> " +exception.getMessage());
        }

        return null;
    }
}
