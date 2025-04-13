package Cipher.Algorithms.TripleDES;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class TripleDES {

    public static @Nullable SecretKey generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.out.println("[TripleDES] Error Encountered while SecretKey Generation --> "+noSuchAlgorithmException.toString());
        }
        return null;
    }

    /**
     * Save the specified TripleDES to the specified file
     *
     * @param secretKey key-type
     * @param file location where to write the SecretKey
     */
    public static void writeKey(SecretKey secretKey, File file) {
        try {
//            Convert the secretKey to an array of bytes like this
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
            DESedeKeySpec deSedeKeySpec = (DESedeKeySpec) secretKeyFactory.getKeySpec(secretKey, DESedeKeySpec.class);
//            KEY IN THE BYTE FORMAT
            byte[] bytes_rawKey = deSedeKeySpec.getKey();

//            WRITING RAW-KEY to the File
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes_rawKey);
            fos.close();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException exception) {
            System.err.println("[TripleDES] Error Encountered while writeKey");
            exception.printStackTrace();
        }
    }

    /**
     * Read the TripleDES secretKey from the given destination file
     *
     * @param file from where the Secrete Key is to read
     * @return SecretKey type
     */
    public static SecretKey readKey(File file) {
        try {
//            Reading the data from the file
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
//            rawBytes from the keyFile
            byte[] bytes_rawKey = new byte[(int) file.length()];
            dataInputStream.readFully(bytes_rawKey);
            dataInputStream.close();

//            Convert the raw bytes to a secretKey like this
            DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(bytes_rawKey);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
            return secretKeyFactory.generateSecret(deSedeKeySpec);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException exception) {
            System.err.println("[TripleDES] Error Encountered while readKey");
            exception.printStackTrace();
        }
        return null;
    }

    public static void encryptMessage(SecretKey secretKey, @NotNull InputStream inputStream, OutputStream outputStream) {
        try {
//            instance of Cipher
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

//            Create a special o/p stream to do the work for us
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);

//            Read from the i/p and write to the ENCRYPTING o/p stream
            byte[] bufferBytes = new byte[2048];
            int readBytes;
            while ((readBytes = inputStream.read(bufferBytes)) != -1) {
                cipherOutputStream.write(bufferBytes, 0, readBytes);
            }
            cipherOutputStream.close();

//            FOR EXTRA SECURITY
//            DON't leave any plaintext hanging around memory
            Arrays.fill(bufferBytes, (byte) 0);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IOException exception) {
            System.out.println("[TripleDES] Error Encountered while encrypting the message --> "+exception.toString());
        }
    }


    /**
     *  Use the specified TripleDES key to decrypt bytes ready from the input
     *  stream and write them to the output stream.
     *  This method uses Cipher directly to show
     *  how it can be done without "CipherInputStream" and "CipherOutputStream".
     *
     * @param secretKey SecretKey used for ENCRYPTION ON MESSAGE BACK TO PLAIN-TEXT
     * @param inputStream input Streamer --> used to write something on file
     * @param outputStream output streamer --> used to read something from file
     */
    public static void decryptMessage(SecretKey secretKey, @NotNull InputStream inputStream, OutputStream outputStream) {
        try {
//            instance of Cipher
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

//            Read bytes, decrypt, and write them out
            byte[] bufferBytes = new byte[2048];
            int readBytes;
            while ((readBytes = inputStream.read(bufferBytes)) != -1) {
                outputStream.write(cipher.update(bufferBytes, 0, readBytes));
            }

//            Write out the final bunch of decrypted bytes
            outputStream.write(cipher.doFinal());
            outputStream.flush();
        } catch (NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | IOException exception) {
            System.out.println("[TripleDES] Error Encountered while encrypting the message --> "+exception.toString());
        }
    }
}
