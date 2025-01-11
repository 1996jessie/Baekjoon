import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int[] f = new int[m + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            f[i] = Integer.parseInt(st.nextToken());
        }

        int maxPower = 20;
        int[][] dp = new int[maxPower + 1][m + 1];
        
        for (int i = 1; i <= m; i++) {
            dp[0][i] = f[i];
        }
        
        for (int i = 1; i <= maxPower; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
            }
        }
        
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= maxPower; j++) {
                if ((n & (1 << j)) != 0) {
                    x = dp[j][x];
                }
            }
            sb.append(x).append("\n");
        }

        System.out.print(sb.toString());
    }
}
