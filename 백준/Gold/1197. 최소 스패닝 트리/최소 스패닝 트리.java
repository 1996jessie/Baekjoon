import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, weight;
        
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int V, E;
    static List<Edge> edges = new ArrayList<>();
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges, (e1, e2) -> Integer.compare(e1.weight, e2.weight));

        int mstWeight = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                mstWeight += edge.weight;
                edgeCount++;
                if (edgeCount == V - 1) {
                    break;
                }
            }
        }

        System.out.println(mstWeight);
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}
