import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        double[][] scores = new double[N + 1][M];
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                int i = Integer.parseInt(st.nextToken());
                double s = Double.parseDouble(st.nextToken());
                scores[i][j] = s;
            }
        }
        List<double[]> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                candidates.add(new double[]{scores[i][j], i});
            }
        }
        candidates.sort((a, b) -> Double.compare(b[0], a[0]));
        boolean[] chosen = new boolean[N + 1];
        double total = 0.0;
        int count = 0;
        for (double[] c : candidates) {
            int idx = (int)c[1];
            if (!chosen[idx]) {
                chosen[idx] = true;
                total += c[0];
                count++;
                if (count == K) {
                    break;
                }
            }
        }
        System.out.printf("%.1f\n", total);
    }
}

