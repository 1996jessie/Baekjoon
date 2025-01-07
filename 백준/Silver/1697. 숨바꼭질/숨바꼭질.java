import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int[] time = new int[100001];
        Arrays.fill(time, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : new int[]{current - 1, current + 1, current * 2}) {
                if (next >= 0 && next <= 100000 && time[next] == -1) {
                    time[next] = time[current] + 1;
                    queue.offer(next);
                    if (next == K) {
                        System.out.println(time[next]);
                        return;
                    }
                }
            }
        }
    }
}
