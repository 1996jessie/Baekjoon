import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long[][] points;
    private static boolean[] visited;
    private static double minLength;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            points = new long[N][2];
            visited = new boolean[N];
            minLength = Double.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Long.parseLong(st.nextToken());
                points[i][1] = Long.parseLong(st.nextToken());
            }

            dfs(0, 0);
            sb.append(String.format("%.6f\n", minLength));
        }

        System.out.print(sb);
    }

    private static void dfs(int idx, int count) {
        if (count == N / 2) {
            calculate();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculate() {
        long sumX = 0, sumY = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                sumX += points[i][0];
                sumY += points[i][1];
            } else {
                sumX -= points[i][0];
                sumY -= points[i][1];
            }
        }

        double length = Math.sqrt(sumX * sumX + sumY * sumY);
        minLength = Math.min(minLength, length);
    }
}
