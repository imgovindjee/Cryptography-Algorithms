package Cipher.Algorithms.Cipher.Railfence;

import java.util.Scanner;

public class RailfenceMain {
    public void run () throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("[Railfence-Main] Enter a Message to Encrypt --> ");
        String userMessage = sc.nextLine();

        System.out.print("[Railfence-Main] Enter the Depth for the \"Railfence Algorithm\" --> ");
        int depth = sc.nextInt();
        System.out.println("\n\n");

//        Creating a class instance
        Railfence railfence = new Railfence();
//        ENCRYPT AND DECRYPT MESSAGE
        String encryptMessage = railfence.encryptMessage(userMessage, depth);
        System.out.println("[Railfence-Main] Encrypted Message is --> "+encryptMessage);

        String decryptMessage = railfence.decryptMessage(encryptMessage, depth);
        System.out.println("[Railfence-Main] Decrypted Message is --> "+decryptMessage);
    }

    public static void main(String[] args) throws Exception {
        RailfenceMain railfenceMain = new RailfenceMain();
        railfenceMain.run();
    }
}
