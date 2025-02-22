import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scores = new int[N];
        int maxScore = 0;
        double newSum = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        for (int i = 0; i < N; i++) {
            newSum += (double) scores[i] / maxScore * 100;
        }

        System.out.println(newSum / N);
    }
}
