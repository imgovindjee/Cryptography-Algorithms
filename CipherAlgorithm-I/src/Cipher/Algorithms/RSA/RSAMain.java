package Cipher.Algorithms.RSA;

import java.util.Scanner;

public class RSAMain {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[RSA-Main] : Enter a Message to Encrypt.");
        String userMessage = sc.nextLine();

        System.out.println("\n\n");

        RSA rsa = new RSA();
        byte[] userMessageToBytes = userMessage.getBytes();
        System.out.println("[RSA-Main] userMessage to Bytes: "+rsa.bytesToString(userMessageToBytes));

//        ENCRYPTED MESSAGE
        byte[] encryptedMessage = rsa.encryptMessage(userMessageToBytes);
        System.out.println("[RSA-Main] Encrypted Message : "+rsa.bytesToString(encryptedMessage));

//        DECRYPTED MESSAGE
        byte[] decryptedMessage = rsa.decryptMessage(encryptedMessage);
        System.out.println("[RSA-Main] Decrypted Message : "+rsa.bytesToString(decryptedMessage));

//        NOTE:-  EXTRA TIPS
        System.out.println("userMessageToBytes equals decryptedMessage After encryption : "+rsa.bytesToString(userMessageToBytes).equals(rsa.bytesToString(decryptedMessage)));
    }

    public static void main(String[] args) {
        RSAMain rsaMain = new RSAMain();
        rsaMain.run();
    }
}
