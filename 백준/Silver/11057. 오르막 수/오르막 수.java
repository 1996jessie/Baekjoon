import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][j]) % 10007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % 10007;
        }
        System.out.println(sum);
    }
}
