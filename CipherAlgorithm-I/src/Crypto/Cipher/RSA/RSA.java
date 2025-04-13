package Crypto.Cipher.RSA;

import org.jetbrains.annotations.Nullable;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSA {

    public static @Nullable KeyPair generateKeyPair () {
        boolean flag = true;
        System.out.println("[SecretKeyPairGeneration] Generating .....");
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception exception) {
            flag = false;
            System.err.println("[RSA] Error Encountered while Generating the SecretKey --> "+exception.toString());
        } finally {
            if (flag) {
                System.out.println("[SecretKeyPairGeneration] Successfully KeyPair Generated\n");
            }
        }
        return null;
    }

    public static @Nullable String encryptMessage (String message, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedMessage);
        } catch (Exception exception) {
            System.out.println("[RSA] Error Encountered while Encrypting the Data --> " +exception.getMessage());
        }

        return null;
    }

    public static @Nullable String decryptMessage (String message, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] decodedMessage = Base64.getDecoder().decode(message);
            return new String(cipher.doFinal(decodedMessage));
        } catch (Exception exception) {
            System.out.println("[RSA] Error Encountered while Decrypting the Data --> " +exception.getMessage());
        }

        return null;
    }
}
