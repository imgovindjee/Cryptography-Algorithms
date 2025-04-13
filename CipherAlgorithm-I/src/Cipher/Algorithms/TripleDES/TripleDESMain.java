package Cipher.Algorithms.TripleDES;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.crypto.SecretKey;
import java.io.File;
import java.util.Scanner;

public class TripleDESMain {

    @Contract(" -> new")
    private static @NotNull File getFile(@NotNull Scanner sc) {
        System.out.println("[TripleDES Main] Enter the file Location --> ");
        String file = sc.nextLine();
        return new File(file);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
//        Getting the file
        File file = getFile(sc);

        System.out.print("[TripleDES Main] Enter a Message to Encrypt --> ");
        String userMessage = sc.nextLine();

//        Generate Key
        SecretKey secretKey = TripleDES.generateKey();
//        Write key on to file
        TripleDES.writeKey(secretKey, file);
        System.out.println("[TripleDES Main] Write key onto file....");

//        GETTING THE SECRET KEY FROM THE FILE
        System.out.println("[TripleDES Main] Getting the SecretKey...");
        SecretKey key = TripleDES.readKey(file);
        System.out.println("[TripleDES Main] key Extracted successfully");
        System.out.println("\n");

//        ENCRYPTING THE MESSAGE
        System.out.println("[TripleDES Main] Encrypting the Message....");
        TripleDES.encryptMessage(secretKey, System.in, System.out);
        System.out.println("[TripleDES Main] Message Encrypted successfully....");
        System.out.println("\n");

//        ENCRYPTING THE MESSAGE
        System.out.println("[TripleDES Main] Encrypting the Message....");
        TripleDES.decryptMessage(secretKey, System.in, System.out);
        System.out.println("[TripleDES Main] Message Encrypted successfully....");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        TripleDESMain tripleDESMain = new TripleDESMain();
        tripleDESMain.run();
    }
}
