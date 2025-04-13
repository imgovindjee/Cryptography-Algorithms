package Crypto.Cipher.IDEA;

import javax.crypto.SecretKey;
import java.util.Scanner;

public class IDEAMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[IDEA Main] : Enter the message to Encrypt --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        SECRET-KEY
        SecretKey secretKey = IDEA.generateSecretKey();

//        ENCRYPTING THE MESSAGE
        String encryptedMessage = IDEA.encryptMessage(userMessage, secretKey);
        System.out.println("[IDEA Main] : Encrypted Message is --> "+encryptedMessage);

//        DECRYPTING THE MESSAGE
        String decryptedMessage = IDEA.decryptMessage(encryptedMessage, secretKey);
        System.out.println("[IDEA Main] : Decrypted Message is --> "+decryptedMessage);
    }
}
