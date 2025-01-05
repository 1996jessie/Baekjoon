import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;
    static final int MAX = 4000000;
    
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        precompute();
        System.out.println(binomial(N, K));
    }

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MAX] = modInverse(fact[MAX]);
        for (int i = MAX - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    static long modInverse(long a) {
        return power(a, MOD - 2);
    }

    static long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp /= 2;
        }
        return result;
    }

    static long binomial(int N, int K) {
        if (K > N) return 0;
        return fact[N] * invFact[K] % MOD * invFact[N - K] % MOD;
    }
}
