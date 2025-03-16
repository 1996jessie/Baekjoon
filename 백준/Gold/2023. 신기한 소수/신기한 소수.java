import java.util.*;

public class Main {
    static int N;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        int[] primes = {2, 3, 5, 7};
        for (int p : primes) {
            dfs(p, 1);
        }

        for (int num : result) {
            System.out.println(num);
        }
    }

    static void dfs(int num, int length) {
        if (length == N) {
            result.add(num);
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int nextNum = num * 10 + i;
            if (isPrime(nextNum)) {
                dfs(nextNum, length + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
