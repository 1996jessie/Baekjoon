import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        long maxTime = 0;

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        long left = 1, right = maxTime * (long) M;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;
                if (count >= M) break;
            }

            if (count >= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
