import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 401;
    static int N, P;
    static int[][] capacity, flow;
    static List<Integer>[] graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        capacity = new int[MAX][MAX];
        flow = new int[MAX][MAX];
        graph = new ArrayList[MAX];
        parent = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
            capacity[u][v] = 1;
        }

        System.out.println(maxFlow(1, 2));
    }

    static int maxFlow(int source, int sink) {
        int totalFlow = 0;

        while (true) {
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            parent[source] = source;

            while (!queue.isEmpty() && parent[sink] == -1) {
                int current = queue.poll();

                for (int next : graph[current]) {
                    if (parent[next] == -1 && capacity[current][next] > flow[current][next]) {
                        parent[next] = current;
                        queue.add(next);
                        if (next == sink) break;
                    }
                }
            }

            if (parent[sink] == -1) break;

            int minFlow = Integer.MAX_VALUE;
            for (int i = sink; i != source; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            for (int i = sink; i != source; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            totalFlow += minFlow;
        }

        return totalFlow;
    }
}
