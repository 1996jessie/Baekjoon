import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] coins = {25, 10, 5, 1};

        for (int t = 0; t < T; t++) {
            int C = sc.nextInt();
            int[] result = new int[4];

            for (int i = 0; i < coins.length; i++) {
                result[i] = C / coins[i];
                C %= coins[i];
            }

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
