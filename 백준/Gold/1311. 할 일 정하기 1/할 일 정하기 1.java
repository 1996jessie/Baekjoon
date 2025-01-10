import java.io.*;

public class Main {
    static int N;
    static int[][] D;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        D = new int[N][N];
        dp = new int[N][(1 << N)];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (1 << N); j++) {
                dp[i][j] = -1;
            }
        }

        int result = solve(0, 0);
        System.out.println(result);
    }

    public static int solve(int person, int assigned) {
        if (assigned == (1 << N) - 1) {
            return 0;
        }

        if (dp[person][assigned] != -1) {
            return dp[person][assigned];
        }

        int minCost = Integer.MAX_VALUE;

        for (int job = 0; job < N; job++) {
            if ((assigned & (1 << job)) == 0) {
                int cost = D[person][job] + solve(person + 1, assigned | (1 << job));
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[person][assigned] = minCost;
    }
}
