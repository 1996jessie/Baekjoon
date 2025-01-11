import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 17;
    static int[] depth;
    static int[][] parent;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        
        depth = new int[N + 1];
        parent = new int[MAX + 1][N + 1];
        
        dfs(1, 0);
        
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= N; j++) {
                if (parent[i - 1][j] != -1) {
                    parent[i][j] = parent[i - 1][parent[i - 1][j]];
                }
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            sb.append(LCA(u, v)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int node, int par) {
        parent[0][node] = par;
        for (int next : tree[node]) {
            if (next != par) {
                depth[next] = depth[node] + 1;
                dfs(next, node);
            }
        }
    }
    
    static int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        
        for (int i = MAX; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = parent[i][u];
            }
        }
        
        if (u == v) {
            return u;
        }
        
        for (int i = MAX; i >= 0; i--) {
            if (parent[i][u] != parent[i][v]) {
                u = parent[i][u];
                v = parent[i][v];
            }
        }
        
        return parent[0][u];
    }
}
