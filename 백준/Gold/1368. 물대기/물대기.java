import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(br.readLine());
            graph[0].add(new Edge(i, cost));
            graph[i].add(new Edge(0, cost));
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i != j) {
                    graph[i].add(new Edge(j, cost));
                }
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Edge(0, 0));
        int totalCost = 0;
        int count = 0;

        while (!pq.isEmpty() && count <= N) {
            Edge current = pq.poll();
            if (visited[current.to]) {
                continue;
            }
            visited[current.to] = true;
            totalCost += current.cost;
            count++;

            for (Edge next : graph[current.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(totalCost);
    }
}
