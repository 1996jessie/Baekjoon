import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] rows = new int[N + 1];
        int[] cols = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            String[] matrix = br.readLine().split(" ");
            rows[i] = Integer.parseInt(matrix[0]);
            cols[i] = Integer.parseInt(matrix[1]);
        }
        
        int[][] dp = new int[N][N];
        
        for (int len = 1; len < N; len++) {
            for (int i = 0; i < N - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + rows[i] * cols[k] * cols[j]);
                }
            }
        }
        
        System.out.println(dp[0][N - 1]);
    }
}
