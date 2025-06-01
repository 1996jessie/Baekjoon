import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i - 1][0] << 1) | grid[i][0];
            dp[0][i] = (dp[0][i - 1] << 1) | grid[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                long maxPrev = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = (maxPrev << 1) | grid[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
