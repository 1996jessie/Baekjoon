import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] temperatures = new int[N];

        for (int i = 0; i < N; i++) {
            temperatures[i] = sc.nextInt();
        }

        int currentSum = 0;
        for (int i = 0; i < K; i++) {
            currentSum += temperatures[i];
        }

        int maxSum = currentSum;

        for (int i = K; i < N; i++) {
            currentSum += temperatures[i] - temperatures[i - K];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
        sc.close();
    }
}
