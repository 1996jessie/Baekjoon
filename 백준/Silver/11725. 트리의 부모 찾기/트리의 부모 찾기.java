import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        findParents(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void findParents(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int child : tree[current]) {
                if (parent[child] == 0) { 
                    parent[child] = current;
                    queue.add(child);
                }
            }
        }
    }
}
