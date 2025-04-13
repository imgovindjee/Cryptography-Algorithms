package Crypto.Cipher.DES;

import javax.crypto.SecretKey;
import java.util.Scanner;

public class DESMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[DES Main] : Enter the message to Encrypt --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        SECRET-KEY
        SecretKey secretKey = DES.generateSecretKey();

//        ENCRYPTING THE MESSAGE
        String encryptedMessage = DES.encryptMessage(userMessage, secretKey);
        System.out.println("[DES Main] Encrypted Message is --> "+encryptedMessage);

//        DECRYPTED MESSAGE
        String decryptedMessage = DES.decryptedMessage(encryptedMessage, secretKey);
        System.out.println("[DES Main] Decrypted Message is --> "+decryptedMessage);
    }
}
