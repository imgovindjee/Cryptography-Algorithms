package Cipher.Algorithms.WEP_XOR;

import java.util.Scanner;

public class WEP_XORMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        USER MESSAGE
        System.out.print("[WEP-XORMain] Enter a Message to Encrypt --> ");
        String userMessage = sc.nextLine();

//        USER ONE CHAR KEY FOR ENCRYPTION AND DECRYPTION
        System.out.print("[WEP-XORMain] : Enter one Character key --> ");
        char key = sc.next().charAt(0);
        System.out.println("\n\n");

//        ENCRYPTING AND DECRYPTING
        String encryptedMessage = WEP_XOR.XORImplementation(userMessage, key);
        System.out.println("[WEP-XORMain] Encrypted Message is --> "+encryptedMessage);

        String decryptedMessage = WEP_XOR.XORImplementation(encryptedMessage, key);
        System.out.println("[WEP-XORMain] Decrypted Message is --> "+decryptedMessage);
    }
}
