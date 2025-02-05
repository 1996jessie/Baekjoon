import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= K; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] values = br.readLine().split(" ");
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(values[i]);
            }
            
            int[] dp = new int[n];
            dp[0] = v[0];
            if (n > 1) {
                dp[1] = Math.max(v[0], v[1]);
            }
            
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + v[i]);
            }
            
            System.out.println("Data Set " + t + ":");
            System.out.println(dp[n-1]);
            System.out.println();
        }
    }
}
