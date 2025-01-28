import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M, start, end;
    static List<Edge>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(binarySearch());
    }

    static boolean canTransport(int weight) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return true;
            }

            for (Edge edge : graph[current]) {
                if (!visited[edge.to] && edge.weight >= weight) {
                    visited[edge.to] = true;
                    queue.add(edge.to);
                }
            }
        }

        return false;
    }

    static int binarySearch() {
        int left = 1;
        int right = 1_000_000_000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canTransport(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
