package Cipher.Algorithms.Cipher.Railfence;

import org.jetbrains.annotations.NotNull;

public class Railfence {

    public @NotNull String encryptMessage(@NotNull String message, int depth) throws Exception {
        int len = message.length();

        int row = depth, col = len / depth;
        char[][] mat = new char[row][col];
        int idx = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++){
                if (idx != len) {
                    mat[j][i] = message.charAt(idx++);
                } else {
                    mat[j][i] = 'X';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] m : mat){
            for (char ch : m) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public @NotNull String decryptMessage (@NotNull String message, int depth) throws Exception {
        int len = message.length();

        int row = depth, col = len / depth;
        char[][] mat = new char[row][col];
        int idx = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                mat[i][j] = message.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++) {
                sb.append(mat[j][i]);
            }
        }
        return sb.toString();
    }
}
