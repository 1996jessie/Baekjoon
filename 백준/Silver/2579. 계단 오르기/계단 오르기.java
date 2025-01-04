import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stair = new int[n + 1];
        int[] score = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stair[i] = sc.nextInt();
        }

        score[1] = stair[1];
        if (n > 1) {
            score[2] = stair[1] + stair[2];
        }
        if (n > 2) {
            score[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
        }

        for (int i = 4; i <= n; i++) {
            int a = score[i - 2] + stair[i];
            int b = score[i - 3] + stair[i - 1] + stair[i];
            score[i] = Math.max(a, b);
        }

        System.out.println(score[n]);
        sc.close();
    }
}
