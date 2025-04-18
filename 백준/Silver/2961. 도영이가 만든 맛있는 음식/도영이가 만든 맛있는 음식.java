import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;

    static void dfs(int index, int s, int b, boolean used) {
        if (index == N) {
            if (used) {
                int diff = Math.abs(s - b);
                if (diff < result) {
                    result = diff;
                }
            }
            return;
        }

        dfs(index + 1, s * arr[index][0], b + arr[index][1], true);
        dfs(index + 1, s, b, used);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, false);
        System.out.println(result);
    }
}
