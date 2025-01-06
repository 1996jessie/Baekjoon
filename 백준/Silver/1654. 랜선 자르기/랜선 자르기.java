import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lengths = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lengths[i] = Long.parseLong(br.readLine());
            if (lengths[i] > max) {
                max = lengths[i];
            }
        }

        long left = 1, right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (long len : lengths) {
                count += len / mid;
            }

            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
