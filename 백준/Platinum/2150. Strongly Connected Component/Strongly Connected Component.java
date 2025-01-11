import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static List<Integer>[] graph, reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stack;
    static List<List<Integer>> SCCs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        reverseGraph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        stack = new Stack<>();
        SCCs = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            reverseGraph[v].add(u);
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> SCC = new ArrayList<>();
                dfs2(node, SCC);
                Collections.sort(SCC);
                SCCs.add(SCC);
            }
        }

        Collections.sort(SCCs, (a, b) -> a.get(0) - b.get(0));
        System.out.println(SCCs.size());
        for (List<Integer> scc : SCCs) {
            for (int node : scc) {
                System.out.print(node + " ");
            }
            System.out.println(-1);
        }
    }

    static void dfs1(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        stack.push(node);
    }

    static void dfs2(int node, List<Integer> SCC) {
        visited[node] = true;
        SCC.add(node);
        for (int next : reverseGraph[node]) {
            if (!visited[next]) {
                dfs2(next, SCC);
            }
        }
    }
}
