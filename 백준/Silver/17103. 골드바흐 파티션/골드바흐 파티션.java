import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int MAX = 1000000;
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

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int count = 0;

            for (int i = 2; i <= N / 2; i++) {
                if (!isNotPrime[i] && !isNotPrime[N - i]) {
                    count++;
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}
