import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        calculate(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate(int idx, int result) {
        if (idx == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int nextResult = 0;
                if (i == 0) {
                    nextResult = result + numbers[idx + 1];
                } else if (i == 1) {
                    nextResult = result - numbers[idx + 1];
                } else if (i == 2) {
                    nextResult = result * numbers[idx + 1];
                } else if (i == 3) {
                    nextResult = result / numbers[idx + 1];
                }

                calculate(idx + 1, nextResult);

                operators[i]++;
            }
        }
    }
}
