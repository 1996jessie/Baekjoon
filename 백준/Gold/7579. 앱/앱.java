import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] memory = new int[N];
        int[] cost = new int[N];

        for (int i = 0; i < N; i++) {
            memory[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
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

        System.out.println(minCost);
    }
}

