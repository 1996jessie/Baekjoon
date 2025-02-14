import java.io.*;

public class Main {
    static final int MOD = 1_000_000_009;
    static final int MAX_N = 1_000_000;
    static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        dp[0] = 1;
        for (int i = 1; i <= MAX_N; i++) {
            if (i >= 1) dp[i] = (dp[i] + dp[i - 1]) % MOD;
            if (i >= 2) dp[i] = (dp[i] + dp[i - 2]) % MOD;
            if (i >= 3) dp[i] = (dp[i] + dp[i - 3]) % MOD;
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
