import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        boolean hasNegativeCycle = false;
        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    if (i == n) {
                        hasNegativeCycle = true;
                    }
                }
            }
        }

        if (hasNegativeCycle) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    bw.write("-1\n");
                } else {
                    bw.write(dist[i] + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
