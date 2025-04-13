package Cipher.Algorithms.SHA256;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA256 {

    public static byte @Nullable [] getSHA(@NotNull String message) {
        try {
//        getting the instance of MessageDigest as "SHA-256"
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

//        digest() method called to calculate message digest of an i/p
//        and return array of byte[]
            return messageDigest.digest(message.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.out.println("[SHA256] No Such Algorithm : "+noSuchAlgorithmException.toString());
        }

        return null;
    }


    public static @NotNull String toHexString(byte[] hashBytes) {
//        Convert byte array into signum representation
        BigInteger bigInteger = new BigInteger(1, hashBytes);

//        convert message digest into hex-value
        StringBuilder sb_hexString = new StringBuilder(bigInteger.toString(16));
        while (sb_hexString.length() < 32) {
            sb_hexString.insert(0, '0');
        }
        return sb_hexString.toString();
    }
}
