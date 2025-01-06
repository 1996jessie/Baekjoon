import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[][] result = fibMatrixPower(n - 1);
        System.out.println(result[0][0]);
    }

    static int[][] fibMatrixPower(long exp) {
        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = {{1, 0}, {0, 1}};
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiplyMatrix(result, base);
            }
            base = multiplyMatrix(base, base);
            exp /= 2;
        }
        return result;
    }

    static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (int) ((result[i][j] + (long) a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        return result;
    }
}
