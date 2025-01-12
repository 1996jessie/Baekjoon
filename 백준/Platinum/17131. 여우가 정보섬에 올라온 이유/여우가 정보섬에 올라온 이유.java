import java.util.*;
import java.io.*;

public class Main {

    static final int MOD = 1000000007;
    static int N;
    static Vec[] arr = new Vec[200000];

    static class Vec {
        int x, y;

        Vec(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Tree {
        int[] node = new int[800000];

        void insert(int cur, int left, int right, int index, int val) {
            if (left == right) {
                node[cur] += val;
                return;
            }
            int mid = (left + right) / 2;
            if (index <= mid) {
                insert(cur * 2, left, mid, index, val);
            } else {
                insert(cur * 2 + 1, mid + 1, right, index, val);
            }
            node[cur] = node[cur * 2] + node[cur * 2 + 1];
        }

        long search(int cur, int left, int right, int start, int end) {
            if (left > end || right < start) {
                return 0;
            }
            if (left <= start && right >= end) {
                return node[cur];
            }
            int mid = (start + end) / 2;
            long sum = 0;
            if (left <= mid) {
                sum += search(cur * 2, left, right, start, mid);
            }
            if (right > mid) {
                sum += search(cur * 2 + 1, left, right, mid + 1, end);
            }
            return sum;
        }
    }

    static Tree t = new Tree();
    static List<Integer> batchY = new ArrayList<>();

    static void compress() {
        Arrays.sort(arr, 0, N, Comparator.comparingInt(a -> a.x));
        int prev = Integer.MAX_VALUE, rank = -1;
        for (int i = 0; i < N; i++) {
            if (prev != arr[i].x) {
                rank++;
            }
            prev = arr[i].x;
            arr[i].x = rank;
        }
        Arrays.sort(arr, 0, N, Comparator.comparingInt((Vec a) -> a.y).reversed());
    }

    static long batchProcess() {
        long ret = 0;
        for (int itr : batchY) {
            ret = (ret + t.search(1, 0, itr - 1, 0, N - 1) * t.search(1, itr + 1, N - 1, 0, N - 1)) % MOD;
        }
        for (int itr : batchY) {
            t.insert(1, 0, N - 1, itr, 1);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Vec(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        compress();
        long ans = 0;
        int pastY = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (pastY != arr[i].y) {
                ans = (ans + batchProcess()) % MOD;
                batchY.clear();
                pastY = arr[i].y;
            }
            batchY.add(arr[i].x);
        }
        ans = (ans + batchProcess()) % MOD;
        System.out.println(ans);
    }
}
