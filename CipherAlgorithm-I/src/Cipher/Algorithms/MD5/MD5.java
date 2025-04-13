package Cipher.Algorithms.MD5;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class MD5 {
    public static @Nullable String getMD5(@NotNull String message) {
        try {
//            getting the instance of MD5
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

//            digest() --> is called to calculate message digest
//            of an input digest() and returns an array of bytes
            byte[] bytes = messageDigest.digest(message.getBytes());
//            Converting bytes[] --> ArrayType into signum representation
            BigInteger bigInteger = new BigInteger(1, bytes);

            StringBuilder sb = new StringBuilder(bigInteger.toString(16));
            while (sb.length() < 32) {
                sb.insert(0, "0");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.out.println("[MD5] Error occurred While HashCode-Generation : "+noSuchAlgorithmException.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[MD5] Enter a Message to Encrypt --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

        System.out.println("[MD5] using MD5 Algorithm HashCode respect to given i/p message is --> "+getMD5(userMessage));
    }
}
