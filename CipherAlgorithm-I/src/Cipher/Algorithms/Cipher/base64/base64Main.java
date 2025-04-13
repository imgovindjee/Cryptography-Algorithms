package Cipher.Algorithms.Cipher.base64;

import java.util.Scanner;

public class base64Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[base64-Main] Enter a Message to Encrypt --> ");
        String userMessage = sc.nextLine();

        System.out.println("\n\n");
        String encryptedMessage_CIPHERText = base64.encryptMessage(userMessage);
        System.out.println("[base64-Main] Encrypted Message: "+encryptedMessage_CIPHERText);
        System.out.println("[base64-Main] Decrypted Message: "+base64.decryptMessage(encryptedMessage_CIPHERText));
    }
}
