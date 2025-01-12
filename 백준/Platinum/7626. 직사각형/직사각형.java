import java.util.*;
import java.io.*;

public class Main {
    static int N;

    static class Point {
        int val;
        int idx;
        int y1;
        int y2;

        public Point(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    static class Y {
        int val;
        int idx;

        public Y(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    static Point[] x = new Point[400002];
    static Y[] y = new Y[400002];

    static long[] cnt = new long[1600000];
    static long[] sum = new long[1600000];

    static class Tree {
        public Tree() {
            for (int i = 0; i < N * 8; i++) {
                cnt[i] = 0;
                sum[i] = 0;
            }
        }

        void update(int left, int right, int start, int end, int k, int val) {
            int mid = (start + end) / 2;
            if (start >= left && end <= right) {
                cnt[k] += val;
            } else {
                if (left <= mid) update(left, right, start, mid, k * 2, val);
                if (right > mid) update(left, right, mid + 1, end, k * 2 + 1, val);
            }

            if (cnt[k] > 0) {
                sum[k] = y[end + 1].val - y[start].val;
            } else {
                if (start == end) sum[k] = 0;
                else sum[k] = sum[k * 2] + sum[k * 2 + 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long ANS = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int a = 2 * i, b = 2 * i + 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[a] = new Point(Integer.parseInt(st.nextToken()), a);
            x[b] = new Point(Integer.parseInt(st.nextToken()), b);
            y[a] = new Y(Integer.parseInt(st.nextToken()), a);
            y[b] = new Y(Integer.parseInt(st.nextToken()), b);
        }

        Arrays.sort(y, 0, 2 * N, Comparator.comparingInt(a -> a.val));

        for (int i = 0; i < 2 * N; i++) {
            int arr_idx = y[i].idx / 2;
            if (y[i].idx % 2 == 0) {
                x[arr_idx * 2].y1 = i;
                x[arr_idx * 2 + 1].y1 = i;
            } else {
                x[arr_idx * 2].y2 = i;
                x[arr_idx * 2 + 1].y2 = i;
            }
        }

        Arrays.sort(x, 0, 2 * N, Comparator.comparingInt(a -> a.val));

        Tree t = new Tree();
        for (int i = 0; i < 2 * N; i++) {
            if (i > 0) {
                ANS += sum[1] * (x[i].val - x[i - 1].val);
            }
            if (x[i].idx % 2 == 0) {
                t.update(x[i].y1, x[i].y2 - 1, 0, 2 * N - 1, 1, 1);
            } else {
                t.update(x[i].y1, x[i].y2 - 1, 0, 2 * N - 1, 1, -1);
            }
        }

        System.out.println(ANS);
    }
}
