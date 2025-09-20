import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = Integer.parseInt(br.readLine().trim());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine().trim());
        }
        
        boolean[] dp = new boolean[S.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= S.length(); i++) {
            for (String w : words) {
                int len = w.length();
                if (i >= len && dp[i - len] && S.substring(i - len, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        System.out.println(dp[S.length()] ? 1 : 0);
    }
}
