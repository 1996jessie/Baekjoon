import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] wine = new int[n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            wine[i] = sc.nextInt();
        }
        
        if (n == 1) {
            System.out.println(wine[0]);
            return;
        }
        
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        
        if (n >= 3) {
            dp[2] = Math.max(wine[0] + wine[1], Math.max(wine[1] + wine[2], wine[0] + wine[2]));
        }
        
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
        }
        
        System.out.println(dp[n-1]);
        sc.close();
    }
}

