package Crypto.Cipher.MD5;

import java.util.Scanner;

public class MD5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[MD5 Main] Enter a message to hash using MD5-Algorithm --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        HASHING....
        String hashing = MD5.hash(userMessage);
        System.out.println("[MD5 Main] MD5 hashed message is --> "+hashing);
    }
}
