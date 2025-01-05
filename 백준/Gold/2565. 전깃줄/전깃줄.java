import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Wire implements Comparable<Wire> {
        int a, b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Wire other) {
            return Integer.compare(this.a, other.a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Wire[] wires = new Wire[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            wires[i] = new Wire(a, b);
        }

        Arrays.sort(wires);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (wires[j].b < wires[i].b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().orElse(1);

        System.out.println(n - maxLength);

        sc.close();
    }
}
