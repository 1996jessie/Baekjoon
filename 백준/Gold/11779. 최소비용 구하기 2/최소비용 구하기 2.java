import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static ArrayList<Node>[] graph;
    static int[] dist, prev;

    static class Node {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
            prev[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
        printPath(end);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.to]) {
                continue;
            }

            for (Node neighbor : graph[current.to]) {
                int newDist = dist[current.to] + neighbor.cost;
                if (newDist < dist[neighbor.to]) {
                    dist[neighbor.to] = newDist;
                    prev[neighbor.to] = current.to;
                    pq.add(new Node(neighbor.to, newDist));
                }
            }
        }
    }

    static void printPath(int end) {
        if (dist[end] == INF) {
            System.out.println(0);
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }

        Collections.reverse(path);
        System.out.println(path.size());
        for (int city : path) {
            System.out.print(city + " ");
        }
    }
}
