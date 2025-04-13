package Crypto.Cipher.ECC;

import org.jetbrains.annotations.Nullable;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class ECC {

    public static @Nullable KeyPair generateKeyPair() {
        boolean flag = true;
        System.out.println("[SecretKeyGeneration] Generating .....");
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
            return keyPairGenerator.generateKeyPair();
        } catch (Exception exception) {
            flag = false;
            System.out.println("[ECC] Error Encountered while \"generatingKeyPair()\" --> "+exception.toString());
        } finally {
            if (flag) {
                System.out.println("[SecretKeyGeneration] Successfully KeyPair Generated\n");
            }
        }
        return null;
    }

    public static byte[] sign(String message, PrivateKey privateKey) {
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(privateKey);
            signature.update(message.getBytes());
            return signature.sign();
        } catch (Exception exception) {
            System.out.println("[ECC] Error Encountered while \"sign()\" --> "+exception.toString());
        }

        return new byte[0];
    }

    public static boolean verify(String message, PublicKey publicKey, byte[] signatureBytes) {
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initVerify(publicKey);
            signature.update(message.getBytes());
            return signature.verify(signatureBytes);
        } catch (Exception exception) {
            System.out.println("[ECC] Error Encountered while \"verify()\" --> "+exception.toString());
        }

        return false;
    }
}
