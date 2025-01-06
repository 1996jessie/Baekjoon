import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            String[] sizes = br.readLine().split(" ");
            int[] files = new int[K];
            for (int i = 0; i < K; i++) {
                files[i] = Integer.parseInt(sizes[i]);
            }

            System.out.println(minCostToMergeFiles(files));
        }
    }

    public static int minCostToMergeFiles(int[] files) {
        int K = files.length;
        int[][] dp = new int[K][K];
        int[] prefixSum = new int[K + 1];

        for (int i = 0; i < K; i++) {
            prefixSum[i + 1] = prefixSum[i] + files[i];
        }

        for (int len = 2; len <= K; len++) {
            for (int i = 0; i <= K - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + prefixSum[j + 1] - prefixSum[i]);
                }
            }
        }
        
        return dp[0][K - 1];
    }
}
