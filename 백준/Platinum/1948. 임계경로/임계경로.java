import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, m;
    static List<Edge>[] graph, reverse;
    static int[] indeg;
    static int[] dist;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        reverse = new ArrayList[n + 1];
        indeg = new int[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, c));
            reverse[v].add(new Edge(u, c));
            indeg[v]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        topologicalSort(start);

        System.out.println(dist[end]);

        visited = new boolean[n + 1];
        dfs(end, start);
        System.out.println(cnt);
    }

    static void topologicalSort(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] indegCopy = indeg.clone();
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge e : graph[cur]) {
                if (dist[e.to] < dist[cur] + e.cost) {
                    dist[e.to] = dist[cur] + e.cost;
                }
                indegCopy[e.to]--;
                if (indegCopy[e.to] == 0) {
                    q.add(e.to);
                }
            }
        }
    }

    static void dfs(int cur, int start) {
        if (cur == start) return;
        visited[cur] = true;
        for (Edge e : reverse[cur]) {
            if (dist[e.to] + e.cost == dist[cur]) {
                cnt++;
                if (!visited[e.to]) {
                    dfs(e.to, start);
                }
            }
        }
    }
}
