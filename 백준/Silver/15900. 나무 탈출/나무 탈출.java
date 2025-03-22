import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        boolean[] visited = new boolean[N + 1];
        int leafDepthSum = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cur = node[0];
            int depth = node[1];
            boolean isLeaf = true;

            for (int next : tree[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                    isLeaf = false;
                }
            }

            if (isLeaf) {
                leafDepthSum += depth;
            }
        }

        System.out.println(leafDepthSum % 2 == 1 ? "Yes" : "No");
    }
}
