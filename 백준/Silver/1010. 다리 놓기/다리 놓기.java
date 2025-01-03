import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            System.out.println(binomialCoefficient(M, N));
        }

        scanner.close();
    }

    public static int binomialCoefficient(int m, int n) {
        if (n == 0 || n == m) {
            return 1;
        }
        n = Math.min(n, m - n);
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= (m - i);
            result /= (i + 1);
        }
        return result;
    }
}
