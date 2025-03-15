import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] V = new int[N];
            for (int i = 0; i < N; i++) {
                V[i] = sc.nextInt();
            }

            int recordDays = 0;
            int maxVisitors = -1;

            for (int i = 0; i < N; i++) {
                boolean greaterThanPrevious = V[i] > maxVisitors;
                boolean greaterThanNext = (i == N - 1) || (V[i] > V[i + 1]);

                if (greaterThanPrevious && greaterThanNext) {
                    recordDays++;
                }
                if (V[i] > maxVisitors) {
                    maxVisitors = V[i];
                }
            }

            System.out.println("Case #" + t + ": " + recordDays);
        }
    }
}
