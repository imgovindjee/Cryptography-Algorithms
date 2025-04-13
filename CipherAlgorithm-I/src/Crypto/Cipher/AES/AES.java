package Crypto.Cipher.AES;

import org.jetbrains.annotations.Nullable;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AES {

    public static @Nullable SecretKey generateSecretKey () {
        boolean flag = true;
        System.out.println("[SecretKeyGeneration] Generating .....");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        } catch (Exception exception) {
            flag = false;
            System.err.println("[AES] Error Encountered while Generating the SecretKey --> "+exception.toString());
        } finally {
            if (flag) {
                System.out.println("[SecretKeyGeneration] Successfully Key Generated\n");
            }
        }
        return null;
    }

    public static @Nullable String encryptMessage (String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedMessage);
        } catch (Exception exception) {
            System.out.println("[AES] Error Encountered while Encrypting the Data --> " +exception.getMessage());
        }

        return null;
    }

    public static @Nullable String decryptMessage (String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedMessage = Base64.getDecoder().decode(message);
            return new String(cipher.doFinal(decodedMessage));
        } catch (Exception exception) {
            System.out.println("[AES] Error Encountered while Decrypting the Data --> "+exception.getMessage());
        }

        return null;
    }
}
