package Cipher.Algorithms.Cipher.base64;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Base64;


public class base64 {

    /**
     * Encrypt function to encrypt the original user input message
     * Base64 --> class function used to encrypt the string
     * getEncoder() --> is used to get encoder of base54 class
     * encodeToString() --> is encoding the received message to string format
     * getBytes() --> is used to convert original message to bytes
     *
     * @param message that to be encrypted [BASED ON USER I/P]
     * @return String type encoded O/P
     */
    public static String encryptMessage(@NotNull String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    /**
     * Decrypt function to decrypt the encoded message
     * Base64 --> class function used to encrypt the string
     * getDecoder() --> is used to get decoder instance from Base64 class
     * decode() --> is used to decode the encrypted message to bytes
     *
     * @param message that need to be converted into PLAIN TEXT
     * @return String type decoded O/P
     */
    @Contract("_ -> new")
    public static @NotNull String decryptMessage(String message) {
        return new String(Base64.getDecoder().decode(message));
    }
}
