import java.io.*;
import java.util.*;

public class Main {

    static int[] segmentCount = {6, 2, 5, 5, 4, 5, 6, 3, 7, 5};
    static long[][][] dp = new long[2][15][106];
    static String s;
    static long inputTime = 0;
    static long maxC = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        s = br.readLine();
        
        int line = 0;
        
        for (int i = 0; i < s.length(); i++) {
            line += segmentCount[s.charAt(i) - '0'];
            inputTime = inputTime * 10 + (s.charAt(i) - '0');
        }
        
        maxC = (long) Math.pow(10, s.length());
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 106; j++) {
                dp[0][i][j] = maxC * 2;
                dp[1][i][j] = maxC * 2;
            }
        }
        
        for (long i = 0; i < 10; i++) {
            dp[0][0][segmentCount[(int) i]] = Math.min(dp[0][0][segmentCount[(int) i]], i);
            if (s.charAt(s.length() - 1) - '0' < i) {
                dp[1][0][segmentCount[(int) i]] = Math.min(dp[1][0][segmentCount[(int) i]], i);
            }
        }
        
        recurrence(1);
        
        long result = Math.min(maxC + dp[0][s.length() - 1][line], dp[1][s.length() - 1][line]) - inputTime;
        
        sb.append(result).append("\n");
        System.out.print(sb.toString());
    }

    public static void recurrence(int index) {
        if (index == s.length()) {
            return;
        }
        
        for (int i = index * 2; i <= index * 7; i++) {
            long nextTime;
            for (int j = 0; j < 10; j++) {
                nextTime = dp[0][index - 1][i] + (long) Math.pow(10, index) * j;
                dp[0][index][i + segmentCount[j]] = Math.min(dp[0][index][i + segmentCount[j]], nextTime);
                if (s.charAt(s.length() - 1 - index) - '0' < j) {
                    dp[1][index][i + segmentCount[j]] = Math.min(dp[1][index][i + segmentCount[j]], nextTime);
                }
            }
            
            for (int j = s.charAt(s.length() - 1 - index) - '0'; j < 10; j++) {
                nextTime = dp[1][index - 1][i] + (long) Math.pow(10, index) * j;
                dp[1][index][i + segmentCount[j]] = Math.min(dp[1][index][i + segmentCount[j]], nextTime);
            }
        }
        
        recurrence(index + 1);
    }
}
