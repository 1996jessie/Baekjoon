import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int t = 0; t < K; t++) {
            V = sc.nextInt();
            E = sc.nextInt();
            graph = new ArrayList[V + 1];
            color = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
                color[i] = -1;
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            boolean isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == -1) { 
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) { 
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) { 
                    return false;
                }
            }
        }

        return true;
    }
}
