import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] numbers = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        for (int t = 0; t < M; t++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            System.out.println(prefixSum[j] - prefixSum[i - 1]);
        }

        sc.close();
    }
}
