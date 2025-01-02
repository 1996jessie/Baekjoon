import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            System.out.println(findNextPrime(n));
        }

        scanner.close();
    }

    private static long findNextPrime(long n) {
        if (n <= 1) {
            return 2;
        }

        long candidate = n;
        while (true) {
            if (isPrime(candidate)) {
                return candidate;
            } else {
                candidate++;
            }
        }
    }

    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
