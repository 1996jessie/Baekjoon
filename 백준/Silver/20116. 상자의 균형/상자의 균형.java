import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());

        long[] x = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            x[i] = Long.parseLong(st.nextToken());
        }

        double sumX = 0;
        for (int i = n - 1; i > 0; i--) {
            sumX += x[i];
            double centerX = sumX / (n - i);

            if (centerX <= x[i - 1] - L || centerX >= x[i - 1] + L) {
                System.out.println("unstable");
                return;
            }
        }

        System.out.println("stable");
    }
}
