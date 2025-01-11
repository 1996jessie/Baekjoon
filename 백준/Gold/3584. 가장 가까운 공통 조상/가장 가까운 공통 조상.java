import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }

            int[] parent = new int[n + 1];
            boolean[] isNotRoot = new boolean[n + 1];

            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tree.get(a).add(b);
                parent[b] = a;
                isNotRoot[b] = true;
            }

            int root = 0;
            for (int i = 1; i <= n; i++) {
                if (!isNotRoot[i]) {
                    root = i;
                    break;
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            sb.append(findLCA(node1, node2, parent)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    private static int findLCA(int node1, int node2, int[] parent) {
        Set<Integer> ancestors = new HashSet<>();

        while (node1 != 0) {
            ancestors.add(node1);
            node1 = parent[node1];
        }

        while (node2 != 0) {
            if (ancestors.contains(node2)) {
                return node2;
            }
            node2 = parent[node2];
        }

        return -1;
    }
}
