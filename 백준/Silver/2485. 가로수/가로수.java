import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = scanner.nextInt();
        }

        int[] gaps = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            gaps[i] = positions[i + 1] - positions[i];
        }

        int gcd = gaps[0];
        for (int i = 1; i < gaps.length; i++) {
            gcd = gcd(gcd, gaps[i]);
        }

        int additionalTrees = 0;
        for (int gap : gaps) {
            additionalTrees += (gap / gcd) - 1;
        }

        System.out.println(additionalTrees);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
