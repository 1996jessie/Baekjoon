import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 998244353L;
    static long modPow(long a, long e) {
        long res = 1 % MOD;
        a %= MOD;
        while (e > 0) {
            if ((e & 1L) == 1L) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int same = 0;
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == i) same++;
        }
        long p1 = modPow(N - 1, same);
        long p2 = modPow(N - 2, N - same);
        long ans = (p1 * p2) % MOD;
        System.out.println(ans);
    }
}
