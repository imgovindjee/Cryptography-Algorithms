package Crypto.Cipher.AES;


import javax.crypto.SecretKey;
import java.util.Scanner;

public class AESMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[AES Main] : Enter the message to Encrypt --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        SECRET-KEY
        SecretKey secretKey = AES.generateSecretKey();

//        ENCRYPTING MESSAGE
        String encryptedMessage = AES.encryptMessage(userMessage, secretKey);
        System.out.println("[AES Main] Encrypted Message is --> "+encryptedMessage);

//        DECRYPTED MESSAGE
        String decryptedMessage = AES.decryptMessage(encryptedMessage, secretKey);
        System.out.println("[AES Main] Decrypted Message is --> "+decryptedMessage);
    }
}
