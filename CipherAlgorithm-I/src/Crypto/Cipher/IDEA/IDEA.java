package Crypto.Cipher.IDEA;

import org.jetbrains.annotations.Nullable;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;
import java.util.Base64;

public class IDEA {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static @Nullable SecretKey generateSecretKey () {
        boolean flag = true;
        System.out.println("[SecretKeyGeneration] Generating .....");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("IDEA", "BC");
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        } catch (Exception exception) {
            flag = false;
            System.err.println("[IDEA] Error Encountered while Generating the SecretKey --> "+exception.toString());
        } finally {
            if (flag) {
                System.out.println("[SecretKeyGeneration] Successfully KeyPair Generated\n");
            }
        }
        return null;
    }

    public static @Nullable String encryptMessage(String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("IDEA", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedMessage);
        } catch (Exception exception) {
            System.out.println("[IDEA] Error Encountered while Encrypting the Data --> "+exception.toString());
        }

        return null;
    }

    public static @Nullable String decryptMessage(String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("IDEA", "BC");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedMessage = Base64.getDecoder().decode(message);
            byte[] decryptedMessage = cipher.doFinal(decodedMessage);
            return new String(decryptedMessage);
        } catch (Exception exception) {
            System.out.println("[IDEA] Error Encountered while Decrypting the Data --> "+exception.toString());
        }

        return null;
    }
}
