import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static final int INF = 200000000;
    static List<List<Node>> graph = new ArrayList<>();
    static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = 0, path2 = 0;

        path1 += dijkstra(1, v1);
        path1 += dijkstra(v1, v2);
        path1 += dijkstra(v2, N);

        path2 += dijkstra(1, v2);
        path2 += dijkstra(v2, v1);
        path2 += dijkstra(v1, N);

        int result = Math.min(path1, path2);
        System.out.println(result >= INF ? -1 : result);
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.weight > dist[current.vertex]) {
                continue;
            }

            for (Node next : graph.get(current.vertex)) {
                if (dist[next.vertex] > dist[current.vertex] + next.weight) {
                    dist[next.vertex] = dist[current.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return dist[end];
    }
}
