package Cipher.Algorithms.AES;

import java.util.Scanner;
import java.util.UUID;


public class AESMain {

    private final static String secretKey = UUID.randomUUID().toString();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[AES-MAIN] : Enter a Message to Encrypt.");
        String userMessage = sc.nextLine();


        String encryptMessage = AES.encryptMessage(userMessage, secretKey);
        String decryptMessage = AES.decryptMessage(encryptMessage, secretKey);
        System.out.println("\n\n");
        System.out.println("[ENCRYPTED MESSAGE] : "+encryptMessage);
        System.out.println("[DECRYPTED MESSAGE] : "+decryptMessage);
    }
}
