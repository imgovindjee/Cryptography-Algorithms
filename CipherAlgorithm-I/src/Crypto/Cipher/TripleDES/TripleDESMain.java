package Crypto.Cipher.TripleDES;

import javax.crypto.SecretKey;
import java.util.Scanner;

public class TripleDESMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[TripleDES Main] Enter a message to Encrypt using TripleDES-Algorithm --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        KEY GENERATION
        SecretKey secretKey = TripleDES.generateKey();

//        ENCRYPT THE MESSAGE
        String encryptedMessage = TripleDES.encryptMessage(userMessage, secretKey);
        System.out.println("[TripleDES Main] Encrypted Message is --> "+encryptedMessage);

//        ENCRYPT THE MESSAGE
        String decryptedMessage = TripleDES.decryptMessage(encryptedMessage, secretKey);
        System.out.println("[TripleDES Main] Decrypted Message is --> "+decryptedMessage);
    }
}
