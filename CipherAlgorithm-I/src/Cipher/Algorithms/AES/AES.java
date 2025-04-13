package Cipher.Algorithms.AES;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AES {

    private static SecretKeySpec secretKeySpec; // USED AS 'SECRET-KEY FOR ENCRYPT AND DECRYPT THE MESSAGE'
    private static byte[] keyByte;

    public static void setKey(@NotNull String myKey) {
        MessageDigest messageDigest = null;
        try {
            keyByte = myKey.getBytes("UTF-8");
            messageDigest = MessageDigest.getInstance("SHA-1");
            keyByte = messageDigest.digest(keyByte);
            keyByte = Arrays.copyOf(keyByte, 16);
            secretKeySpec = new SecretKeySpec(keyByte, "AES");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException exception) {
            System.err.println("[AES] ERROR ENCOUNTERED......");
            exception.printStackTrace();
        }
    }


    public static @Nullable String encryptMessage(String messageToEncrypt, String secretKey) {
        try {
//            SET THE KEY
            setKey(secretKey);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(messageToEncrypt.getBytes("UTF-8")));
        } catch (Exception exception) {
            System.out.println("[AES] Error While Encrypting the Message --> "+exception.toString());
        }

        return null;
    }


    public static @Nullable String decryptMessage(String messageToDecrypt, String secretKey) {
        try {
//            SET THE SECRET KEY
            setKey(secretKey);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(messageToDecrypt)));
        } catch (Exception exception) {
            System.out.println("[AES] Error While Decrypting the Message --> "+exception.toString());
        }

        return null;
    }
}
