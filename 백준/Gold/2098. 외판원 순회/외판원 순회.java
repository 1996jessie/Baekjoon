import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int INF = 16_000_000;
    static int[][] W, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(dfs(0, 1) + "\n");
        bw.flush();
        br.close();
    }

    static int dfs(int now, int visit) {
        if (visit == (1 << N) - 1) {
            return W[now][0] == 0 ? INF : W[now][0];
        }

        if (dp[now][visit] != -1) {
            return dp[now][visit];
        }

        dp[now][visit] = INF;

        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0 && W[now][i] != 0) {
                dp[now][visit] = Math.min(dp[now][visit], dfs(i, visit | (1 << i)) + W[now][i]);
            }
        }

        return dp[now][visit];
    }
}
