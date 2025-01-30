import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int[] S, combination;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            S = new int[k];
            combination = new int[6];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(combination[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            combination[depth] = S[i];
            dfs(i + 1, depth + 1);
        }
    }
}
