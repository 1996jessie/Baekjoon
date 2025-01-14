import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean found = false;

        for (int len = L; len <= 100; len++) {
            long sum = (long) len * (len - 1) / 2;
            if (N >= sum && (N - sum) % len == 0) {
                long start = (N - sum) / len;
                if (start >= 0) {
                    for (int i = 0; i < len; i++) {
                        bw.write((start + i) + " ");
                    }
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
