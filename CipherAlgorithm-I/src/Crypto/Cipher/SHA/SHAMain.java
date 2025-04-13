package Crypto.Cipher.SHA;

import java.util.Scanner;

public class SHAMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[SHA Main] Enter a message to hash using SHA-Algorithm --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        HASHED MESSAGE
        String hashedMessage = SHA.hash(userMessage);
        System.out.println("[SHA Main] Hashed Message is --> "+hashedMessage);
    }
}
