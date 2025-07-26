import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, cost;
        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int[] parent;
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }
        
        Collections.sort(edges);
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        
        int totalCost = 0;
        int count = 0;
        
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                totalCost += e.cost;
                count++;
                if (count == N - 1) break;
            }
        }
        
        System.out.println(totalCost);
    }
}
