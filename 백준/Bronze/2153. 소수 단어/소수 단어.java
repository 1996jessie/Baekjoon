import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int sum = 0;

        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sum += c - 'a' + 1;
            } else if (c >= 'A' && c <= 'Z') {
                sum += c - 'A' + 27;
            }
        }

        if (isPrime(sum)) {
            System.out.println("It is a prime word.");
        } else {
            System.out.println("It is not a prime word.");
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
