package Crypto.Cipher.SHA256;

import java.util.Scanner;

public class SHA256Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[SHA256 Main] Enter a message to hash using SHA256-Algorithm --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        HASHED MESSAGE
        String hashedMessage = SHA256.hash(userMessage);
        System.out.println("[SHA256 Main] Hashed Message is --> "+hashedMessage);
    }
}
