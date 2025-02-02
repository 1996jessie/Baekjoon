import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] times = new int[n];
        st = new StringTokenizer(br.readLine());

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            if (times[i] > maxTime) {
                maxTime = times[i];
            }
        }

        long left = 1;
        long right = (long) maxTime * m;
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;
                if (count >= m) {
                    break;
                }
            }

            if (count >= m) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
