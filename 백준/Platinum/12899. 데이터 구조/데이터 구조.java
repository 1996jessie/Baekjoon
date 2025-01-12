import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int max = 2000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        tree = new int[4 * max];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (type == 1) {
                update(1, 1, max, x, 1);
            } else {
                int result = query(1, 1, max, x);
                sb.append(result).append("\n");
                update(1, 1, max, result, -1);
            }
        }

        System.out.print(sb);
    }

    static void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) {
            return;
        }
        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    static int query(int node, int start, int end, int k) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (tree[node * 2] >= k) {
            return query(node * 2, start, mid, k);
        } else {
            return query(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
        }
    }
}
