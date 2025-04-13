package Cipher.Algorithms.WEP_XOR;

import org.jetbrains.annotations.NotNull;

public class WEP_XOR {

    public static @NotNull String XORImplementation(@NotNull String message, char key) {
        int len = message.length();
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            sb.append((char) (ch^key));
        }
        return sb.toString();
    }
}
