package Crypto.Cipher.DES;

import org.jetbrains.annotations.Nullable;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class DES {

    public static @Nullable SecretKey generateSecretKey () {
        boolean flag = true;
        System.out.println("[SecretKeyGeneration] Generating .....");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            return keyGenerator.generateKey();
        } catch (Exception exception) {
            flag = false;
            System.err.println("[DES] Error Encountered while Generating the SecretKey --> "+exception.toString());
        } finally {
            if (flag) {
                System.out.println("[SecretKeyGeneration] Successfully KeyPair Generated\n");
            }
        }
        return null;
    }

    public static @Nullable String encryptMessage(String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedMessage);
        } catch (Exception exception) {
            System.out.println("[DES] Error Encountered while Encrypting the Data --> "+exception.toString());
        }

        return null;
    }

    public static @Nullable String decryptedMessage (String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedMessage = Base64.getDecoder().decode(message);
            return new String(cipher.doFinal(decodedMessage));
        } catch (Exception exception) {
            System.out.println("[DES] Error Encountered while Encrypting the Data --> "+exception.toString());
        }

        return null;
    }
}
