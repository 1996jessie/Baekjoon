import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long minRequired = (long) K * (K + 1) / 2;
        if (N < minRequired) {
            System.out.println(-1);
            return;
        }

        long extra = N - minRequired;
        long diff = K - 1;
        if (extra % K == 0) {
            System.out.println(diff);
        } else {
            System.out.println(diff + 1);
        }
    }
}
