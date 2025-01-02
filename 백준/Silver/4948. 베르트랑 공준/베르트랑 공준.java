import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int MAX = 2 * 1000000;
        boolean[] isNotPrime = new boolean[MAX + 1];
        
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isNotPrime[i]) {
                    count++;
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}
