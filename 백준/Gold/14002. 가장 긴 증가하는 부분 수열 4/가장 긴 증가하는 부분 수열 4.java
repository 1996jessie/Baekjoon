import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxLength = 0;
        int lastIndex = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }
        
        System.out.println(maxLength);
        
        List<Integer> lis = new ArrayList<>();
        
        while (lastIndex != -1) {
            lis.add(A[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        
        Collections.reverse(lis);
        
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}
