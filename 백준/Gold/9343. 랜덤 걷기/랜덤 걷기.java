import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] fact, invFact;

    static long modPow(long a, long e) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int maxN = 1_000_000 * 2; 
        fact = new long[maxN + 1];
        invFact = new long[maxN + 1];

        fact[0] = 1;
        for (int i = 1; i <= maxN; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[maxN] = modPow(fact[maxN], MOD - 2);
        for (int i = maxN - 1; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long ans = nCr(2 * N, N) - nCr(2 * N, N - 1);
            if (ans < 0) ans += MOD;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
