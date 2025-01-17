import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> adj = new ArrayList<>();
    static int[] match;
    static boolean[] visited;

    static boolean dfs(int u) {
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                visited[v] = true;
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        match = new int[M + 1];
        Arrays.fill(match, -1);

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int task = Integer.parseInt(st.nextToken());
                adj.get(i).add(task);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[M + 1];
            if (dfs(i)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
