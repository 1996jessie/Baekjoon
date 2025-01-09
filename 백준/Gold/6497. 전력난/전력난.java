import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;

    static class Edge {
        int from, to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            Edge[] edges = new Edge[n];
            int totalCost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(x, y, z);
                totalCost += z;
            }

            Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

            parent = new int[m];
            rank = new int[m];

            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int mstCost = 0;
            int edgeCount = 0;

            for (Edge edge : edges) {
                if (union(edge.from, edge.to)) {
                    mstCost += edge.weight;
                    edgeCount++;
                    if (edgeCount == m - 1) break;
                }
            }

            sb.append(totalCost - mstCost).append("\n");
        }

        System.out.print(sb.toString());
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
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
        return false;
    }
}
