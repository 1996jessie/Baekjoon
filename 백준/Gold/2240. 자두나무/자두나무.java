import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plum = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                int pos = (w % 2 == 0) ? 1 : 2;
                if (plum[t] == pos) {
                    dp[t][w] = dp[t - 1][w] + 1;
                } else {
                    dp[t][w] = dp[t - 1][w];
                }

                if (w > 0) {
                    int prevPos = (w % 2 == 0) ? 2 : 1;
                    int extra = plum[t] == pos ? 1 : 0;
                    dp[t][w] = Math.max(dp[t][w], dp[t - 1][w - 1] + extra);
                }
            }
        }

        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(max, dp[T][w]);
        }

        System.out.println(max);
    }
}
