import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            long total = 0;
            for (int i = 0; i < N; i++) {
                long sum = 0;
                for (int j = i; j < N; j++) {
                    sum += A[j];
                    if (sum < 0) {
                        break;
                    }
                    total += sum;
                }
            }

            System.out.println("Case #" + t + ": " + total);
        }
    }
}
