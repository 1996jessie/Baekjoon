import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        int[] count = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;
        count[N] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curTime = time[cur];

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next >= 0 && next <= 100000) {
                    if (time[next] > curTime + 1) {
                        time[next] = curTime + 1;
                        count[next] = count[cur];
                        queue.add(next);
                    } else if (time[next] == curTime + 1) {
                        count[next] += count[cur];
                    }
                }
            }
        }

        System.out.println(time[K]);
        System.out.println(count[K]);
    }
}
