import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long val;
        Node left, right;

        Node(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.val = 0;
        }

        Node insert(int l, int r, int w, long val) {
            if (l <= w && w <= r) {
                if (l == r) {
                    Node leaf = new Node(null, null);
                    leaf.val = this.val + val;
                    return leaf;
                }
                int m = (l + r) >> 1;
                Node cl = this.left.insert(l, m, w, val);
                Node cr = this.right.insert(m + 1, r, w, val);
                Node leaf = new Node(cl, cr);
                leaf.val = cl.val + cr.val;
                return leaf;
            }
            return this;
        }
    }

    static long query(Node p, int s, int e, int l, int r) {
        if (e < l || r < s) return 0;
        if (l <= s && e <= r) return p.val;
        int m = (s + e) >> 1;
        long ans = 0;
        ans += query(p.left, s, m, l, r);
        ans += query(p.right, m + 1, e, l, r);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        final int MAX_SIZE = 100005;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<List<Integer>> xpos = new ArrayList<>();
            for (int i = 0; i <= MAX_SIZE; i++) {
                xpos.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) + 1;
                int y = Integer.parseInt(st.nextToken()) + 1;
                xpos.get(y).add(x);
            }

            Node[] t = new Node[MAX_SIZE + 2];
            t[0] = new Node(null, null);
            t[0].left = t[0].right = t[0];
            t[0].val = 0;

            for (int y = 1; y < MAX_SIZE; y++) {
                t[y] = t[y - 1];
                for (int x : xpos.get(y)) {
                    t[y] = t[y].insert(1, MAX_SIZE, x, 1);
                }
            }

            long ans = 0;
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken()) + 1;
                int r = Integer.parseInt(st.nextToken()) + 1;
                int b = Integer.parseInt(st.nextToken()) + 1;
                int u = Integer.parseInt(st.nextToken()) + 1;

                ans += query(t[u], 1, MAX_SIZE, l, r);
                ans -= query(t[b - 1], 1, MAX_SIZE, l, r);
            }
            System.out.println(ans);
        }
    }
}
