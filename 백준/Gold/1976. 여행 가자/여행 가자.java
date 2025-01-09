import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = stz.nextToken().equals("1");
            }
        }

        stz = new StringTokenizer(br.readLine(), " ");
        int[] plan = new int[M];
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(stz.nextToken());
        }

        visited = new boolean[N + 1];

        dfs(plan[0]);

        boolean possible = true;
        for (int i = 1; i < M; i++) {
            if (!visited[plan[i]]) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void dfs(int city) {
        visited[city] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[city][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}
