import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] time = new int[101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            for (int t = in; t < out; t++) {
                time[t]++;
            }
        }

        int total = 0;
        for (int t = 1; t <= 100; t++) {
            if (time[t] == 1) {
                total += A;
            } else if (time[t] == 2) {
                total += 2 * B;
            } else if (time[t] == 3) {
                total += 3 * C;
            }
        }

        System.out.println(total);
    }
}
