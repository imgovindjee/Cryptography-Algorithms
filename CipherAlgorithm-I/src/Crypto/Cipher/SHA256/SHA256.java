package Crypto.Cipher.SHA256;

import org.jetbrains.annotations.Nullable;

import java.security.MessageDigest;

public class SHA256 {

    public static @Nullable String hash (String message) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(message.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte hb : hashBytes) {
                sb.append(String.format("%02x", hb));
            }
            return sb.toString();
        } catch (Exception exception) {
            System.out.println("[SHA256] Error Encountered while \"hashing -> hash()\" the Data --> " +exception.getMessage());
        }

        return null;
    }
}
