import java.io.*;
import java.util.*;

public class Main {
    static long[] dp;
    static Map<String, Integer> codon = new HashMap<>();
    static Map<String, Integer> amino = new HashMap<>();
    static String s;
    static int n, len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        len = s.length();
        dp = new long[len];
        Arrays.fill(dp, -1);

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String u = st.nextToken();
            String v = st.nextToken();

            amino.putIfAbsent(v, i);
            codon.put(u, amino.get(v));
        }

        System.out.println(recur(0));
    }

    static long recur(int index) {
        if (index + 2 >= len) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = 0;
        int[] checkCodon = new int[n + 1];
        boolean[] checkComplex = new boolean[n + 1];
        int change = 0;

        for (int i = index; i < len && change < n; i++) {
            int k = 1;
            for (Map.Entry<String, Integer> entry : codon.entrySet()) {
                if (checkCodon[k] != 3 && entry.getKey().charAt(checkCodon[k]) == s.charAt(i)) {
                    checkCodon[k]++;
                    if (checkCodon[k] == 3) {
                        if (!checkComplex[entry.getValue()]) {
                            checkComplex[entry.getValue()] = true;
                            dp[index] = (dp[index] + recur(i + 1) + 1) % 1000000007;
                        }
                        change++;
                    }
                }
                k++;
            }
        }

        return dp[index] % 1000000007;
    }
}
