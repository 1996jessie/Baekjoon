import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] memory = new int[N];
        int[] cost = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(input[i]);
        }

        int totalMemory = 0;
        for (int i = 0; i < N; i++) {
            totalMemory += memory[i];
        }

        int[] dp = new int[totalMemory + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = totalMemory; j >= memory[i]; j--) {
                if (dp[j - memory[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - memory[i]] + cost[i]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = M; i <= totalMemory; i++) {
            minCost = Math.min(minCost, dp[i]);
        }

        bw.write(String.valueOf(minCost));
        bw.flush();
        bw.close();
    }
}
