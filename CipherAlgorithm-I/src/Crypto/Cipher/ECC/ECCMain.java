package Crypto.Cipher.ECC;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class ECCMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("[ECC Main] : Enter the message to Encrypt --> ");
        String userMessage = sc.nextLine();
        System.out.println("\n");

//        KEY-PAIR Generation
        KeyPair keyPair = ECC.generateKeyPair();
        assert keyPair != null;
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

//        ENCRYPTED MESSAGE
        byte[] signature = ECC.sign(userMessage, privateKey);
        System.out.println("[ECC Main] Signature for the message is --> "+ Base64.getEncoder().encodeToString(signature));
//        VERIFY MESSAGE ENCODED
        System.out.println("[ECC Main] Verification for the message \"Signature\" so formed --> "+ECC.verify(userMessage, publicKey, signature));
    }
}
