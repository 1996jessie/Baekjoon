import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int max = 0;
    static int farthestNode = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[node1].add(new Node(node2, cost));
            graph[node2].add(new Node(node1, cost));
        }

        dfs(1, 0);
        max = 0;
        Arrays.fill(visited, false);
        dfs(farthestNode, 0);

        System.out.println(max);
    }

    public static void dfs(int node, int sum) {
        visited[node] = true;
        if (sum > max) {
            max = sum;
            farthestNode = node;
        }

        for (Node temp : graph[node]) {
            int next = temp.to;
            int cost = temp.cost;
            if (!visited[next]) {
                dfs(next, sum + cost);
            }
        }
    }

    static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

