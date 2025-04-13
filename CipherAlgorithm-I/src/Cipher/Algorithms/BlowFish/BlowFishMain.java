package Cipher.Algorithms.BlowFish;

import java.util.Scanner;

public class BlowFishMain {
    public void run () {
        Scanner sc = new Scanner(System.in);
        System.out.print("[Blowfish-Main] Enter a Message to Encrypt --> ");
        String userMessage = sc.nextLine();

        System.out.print("[Blowfish-Main] Enter a Key of size 6 --> ");
        String key = sc.nextLine();

        System.out.print("[Blowfish-Main] Enter 8 digit Number for IV --> ");
        String IV = sc.nextLine();


//        INSTANCE OF 'Blowfish'
        BlowFish blowFish = new BlowFish(key, IV);
//        ENCRYPTION AND DECRYPTION
        String[] encryptedMessage = blowFish.encryptMessage(userMessage, key);
        System.out.println("[Blowfish-Main] Encrypted Message is --> "+encryptedMessage[0]);
        System.out.println("[Blowfish-Main] Encrypted Message is --> Base64 Format : "+encryptedMessage[1]);

        String[] decryptedMessage = blowFish.decryptMessage(encryptedMessage[1], key);
        System.out.println("[Blowfish-Main] Decrypted Message is --> "+decryptedMessage[0]);
    }

    public static void main(String[] args) {
        BlowFishMain blowFishMain = new BlowFishMain();
        blowFishMain.run();
    }
}
