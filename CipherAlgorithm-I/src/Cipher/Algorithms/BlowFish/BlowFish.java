package Cipher.Algorithms.BlowFish;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class BlowFish {

    protected final char[] hexArray = "0987654321ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private String IV;
    private byte[] keyBytes;
    private SecretKeySpec secretKeySpec;
    private Cipher cipher;

    public BlowFish(@NotNull String key, @NotNull String IV) {
        try {
            this.keyBytes = key.getBytes();
            this.IV = IV;

            System.out.println("\n");
            System.out.println("[Blowfish] -----Setting-----");
            System.out.println("[Blowfish] Key --> " + bytesToHex(keyBytes));
            System.out.println("[Blowfish] IV --> " + bytesToHex(IV.getBytes()));
            System.out.println("\n\n");


//        CREATING  A NEW Blowfish Cipher
            secretKeySpec = new SecretKeySpec(keyBytes, "Blowfish");
            cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        } catch (NoSuchPaddingException | NoSuchAlgorithmException exception) {
            System.err.println("[Blowfish] Error Encountered....");
            exception.printStackTrace();
        }
    }

    @Contract(value = "_ -> new", pure = true)
    private @NotNull String bytesToHex(byte @NotNull [] bytes) {
        char[] hexChar = new char[bytes.length * 2];
        for (int idx = 0, n = bytes.length; idx < n; idx++){
            int and = (bytes[idx] & 0xFF);
            hexChar[idx * 2] = hexChar[(and >>> 4)];
            hexChar[idx * 2 + 1] = hexChar[(and & 0x0F)];
        }
        return new String(hexChar);
    }


    @Contract("_, _ -> new")
    public String @NotNull [] encryptMessage(String message, @NotNull String key) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new javax.crypto.spec.IvParameterSpec(IV.getBytes()));

            byte[] byteFormatEncoding = cipher.doFinal(message.getBytes());
            return new String[] {
                    "Hex Format : "+bytesToHex(byteFormatEncoding),
                    Base64.getEncoder().encodeToString(byteFormatEncoding)
            };
        } catch (Exception exception) {
            System.out.println("[Blowfish] Error encountered While Encrypting Message --> "+exception.toString());
        }

        return new String[0];
    }


    @Contract("_, _ -> new")
    public @Nullable String @NotNull [] decryptMessage(String message, String key)  {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new javax.crypto.spec.IvParameterSpec(IV.getBytes()));

            byte[] decryptedMessageInBytes = cipher.doFinal(Base64.getDecoder().decode(message));
            return new String[] {
                    "Normal Text : "+new String(decryptedMessageInBytes),
                    "HEX Format : "+bytesToHex(decryptedMessageInBytes)
            };
        } catch (Exception exception) {
            System.out.println("[Blowfish] Error encountered While Decrypting Message --> "+exception.toString());
        }

        return new String[0];
    }
}
