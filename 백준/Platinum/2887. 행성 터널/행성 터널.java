import java.io.*;
import java.util.*;

public class Main {
    static class Planet {
        int index, x, y, z;
        Planet(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        List<Edge> edges = new ArrayList<>();

        for (int dim = 0; dim < 3; dim++) {
            int finalDim = dim;
            Arrays.sort(planets, (a, b) -> {
                if (finalDim == 0) return a.x - b.x;
                if (finalDim == 1) return a.y - b.y;
                return a.z - b.z;
            });
            for (int i = 1; i < N; i++) {
                int cost = 0;
                if (finalDim == 0) cost = Math.abs(planets[i].x - planets[i - 1].x);
                if (finalDim == 1) cost = Math.abs(planets[i].y - planets[i - 1].y);
                if (finalDim == 2) cost = Math.abs(planets[i].z - planets[i - 1].z);
                edges.add(new Edge(planets[i - 1].index, planets[i].index, cost));
            }
        }

        Collections.sort(edges);

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        long result = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                result += edge.cost;
                count++;
                if (count == N - 1) break;
            }
        }

        System.out.println(result);
    }
}
