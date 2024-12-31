import java.util.*;

public class Main {
    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        List<Integer> primes = new ArrayList<>();
        
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        
        if (primes.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int prime : primes) {
                sum += prime;
                if (prime < min) {
                    min = prime;
                }
            }
            System.out.println(sum);
            System.out.println(min);
        }
        
        sc.close();
    }
}
