import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        dp[0] = 1;

        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= 10000; j++) {
                dp[j] += dp[j - i];
            }
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
