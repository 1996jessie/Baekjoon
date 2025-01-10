import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N];
        long[] y = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        double area = 0;

        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            area += (x[i] * y[next]) - (y[i] * x[next]);
        }

        area = Math.abs(area) / 2.0;
        System.out.printf("%.1f\n", area);
    }
}
