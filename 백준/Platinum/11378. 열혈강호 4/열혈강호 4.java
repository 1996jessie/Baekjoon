import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Integer>[] canDo;
    static int[][] capacity, flow;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        canDo = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            canDo[i] = new ArrayList<>();
        }

        capacity = new int[N + M + 3][N + M + 3];
        flow = new int[N + M + 3][N + M + 3];
        parent = new int[N + M + 3];

        int source = 0;
        int sink = N + M + 1;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int task = Integer.parseInt(st.nextToken());
                canDo[i].add(task);
                capacity[i][N + task] = 1;
            }
            capacity[source][i] = 1;
        }

        capacity[source][N + M + 2] = K;
        for (int i = 1; i <= N; i++) {
            capacity[N + M + 2][i] = K;
        }

        for (int i = 1; i <= M; i++) {
            capacity[N + i][sink] = 1;
        }

        System.out.println(maxFlow(source, sink));
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

                for (int next = 0; next < capacity.length; next++) {
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
