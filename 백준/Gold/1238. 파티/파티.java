import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100000000;
    static int N, M, X;
    static List<int[]>[] graph, reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, t});
            reverseGraph[v].add(new int[]{u, t});
        }

        int[] toX = dijkstra(graph, X);
        int[] fromX = dijkstra(reverseGraph, X);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, toX[i] + fromX[i]);
        }
        System.out.println(maxTime);
    }

    private static int[] dijkstra(List<int[]>[] graph, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], cost = curr[1];

            if (cost > dist[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0], nextCost = cost + edge[1];
                if (nextCost < dist[v]) {
                    dist[v] = nextCost;
                    pq.add(new int[]{v, nextCost});
                }
            }
        }
        return dist;
    }
}
