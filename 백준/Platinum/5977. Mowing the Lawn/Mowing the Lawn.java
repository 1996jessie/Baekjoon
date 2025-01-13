import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] a = new long[(int) n + 1];
        long[] p = new long[(int) n + 1];
        long[] dp = new long[(int) n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(br.readLine());
            p[i] = p[i - 1] + a[i];
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(y.value, x.value));
        pq.offer(new Pair(0, 0));

        for (int i = 1; i <= n; i++) {
            while (!pq.isEmpty() && pq.peek().index < i - k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                dp[i] = p[i] + pq.peek().value;
            }
            pq.offer(new Pair(dp[i - 1] - p[i], i));
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[(int) n]);
    }

    static class Pair {
        long value;
        int index;

        Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
