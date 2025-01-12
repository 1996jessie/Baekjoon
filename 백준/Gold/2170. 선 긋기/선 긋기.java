import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            intervals.add(new int[]{x, y});
        }

        Collections.sort(intervals, (a, b) -> a[0] - b[0]);

        long totalLength = 0;
        int[] current = intervals.get(0);
        for (int i = 1; i < N; i++) {
            int[] next = intervals.get(i);
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                totalLength += (long) (current[1] - current[0]);
                current = next;
            }
        }
        totalLength += (long) (current[1] - current[0]);

        System.out.println(totalLength);
    }
}
