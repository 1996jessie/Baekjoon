import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] baskets = new int[N];

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int ball = sc.nextInt();

            for (int j = start; j <= end; j++) {
                baskets[j] = ball;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(baskets[i] + " ");
        }

        sc.close();
    }
}
