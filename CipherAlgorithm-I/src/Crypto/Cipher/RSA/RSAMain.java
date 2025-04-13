package Crypto.Cipher.RSA;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class RSAMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[RSA Main] Enter a message to Encrypt using RSA-Algorithm --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        GENERATING THE KEY-PAIR
        KeyPair keyPair = RSA.generateKeyPair();
        assert keyPair != null;
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

//        ENCRYPTING THE MESSAGE
        String encryptingMessage = RSA.encryptMessage(userMessage, publicKey);
        System.out.println("[RSA] Encrypted Message is --> "+encryptingMessage);

//        DECRYPTING THE MESSAGE
        String decryptingMessage = RSA.decryptMessage(encryptingMessage, privateKey);
        System.out.println("[RSA] Decrypted Message is --> "+decryptingMessage);
    }
}
