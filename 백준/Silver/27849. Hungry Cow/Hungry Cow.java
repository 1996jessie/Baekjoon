import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        long[] d = new long[N];
        long[] b = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());
        }
        long eaten = 0;
        long hay = 0;
        long prev = 1;
        for (int i = 0; i < N; i++) {
            long days = d[i] - prev;
            long eat = Math.min(hay, days);
            eaten += eat;
            hay -= eat;
            hay += b[i];
            prev = d[i];
            if (hay > 0) {
                eaten++;
                hay--;
            }
            prev++;
        }
        if (prev <= T) {
            long days = T - prev + 1;
            long eat = Math.min(hay, days);
            eaten += eat;
        }
        System.out.println(eaten);
    }
}
