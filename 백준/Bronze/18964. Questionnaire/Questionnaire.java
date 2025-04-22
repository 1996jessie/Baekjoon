import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_TRY = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        Random rand = new Random();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < MAX_TRY; t++) {
            int i = rand.nextInt(n);
            int j = rand.nextInt(n);
            if (i == j) continue;

            int diff = Math.abs(a[i] - a[j]);
            if (diff == 0) continue;

            for (int d = 1; d * d <= diff; d++) {
                if (diff % d == 0) {
                    checkAndPrint(a, n, d);
                    checkAndPrint(a, n, diff / d);
                }
            }
        }
    }

    static void checkAndPrint(int[] a, int n, int m) {
        if (m <= 1) return;

        Map<Integer, Integer> count = new HashMap<>();
        for (int x : a) {
            int mod = x % m;
            count.put(mod, count.getOrDefault(mod, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() * 2 >= n) {
                System.out.println(m + " " + entry.getKey());
                System.exit(0);
            }
        }
    }
}
