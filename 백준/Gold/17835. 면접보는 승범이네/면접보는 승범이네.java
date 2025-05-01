import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M, K;
    static List<Edge>[] graph;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v].add(new Edge(u, c));
        }

        st = new StringTokenizer(br.readLine());
        Queue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        while (st.hasMoreTokens()) {
            int interviewCity = Integer.parseInt(st.nextToken());
            dist[interviewCity] = 0;
            pq.offer(new Edge(interviewCity, 0));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.weight > dist[cur.to]) continue;

            for (Edge e : graph[cur.to]) {
                if (dist[e.to] > dist[cur.to] + e.weight) {
                    dist[e.to] = dist[cur.to] + e.weight;
                    pq.offer(new Edge(e.to, (int) dist[e.to]));
                }
            }
        }

        int city = 0;
        long maxDist = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(maxDist);
    }
}
