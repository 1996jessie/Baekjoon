import java.io.*;
import java.util.*;

public class Main {
    static long[] arr, tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        arr = new long[N + 1];
        tree = new long[4 * N];
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        buildTree(1, 1, N);
        
        StringBuilder sb = new StringBuilder();
        while (M + K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if (a == 1) {
                update(1, 1, N, b, c - arr[b]);
                arr[b] = c;
            } else {
                sb.append(query(1, 1, N, b, (int)c) + "\n");
            }
        }
        
        System.out.print(sb);
    }

    static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(2 * node, start, mid);
            buildTree(2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if (start <= idx && idx <= end) {
            tree[node] += diff;
            if (start != end) {
                int mid = (start + end) / 2;
                update(2 * node, start, mid, idx, diff);
                update(2 * node + 1, mid + 1, end, idx, diff);
            }
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, left, right) + query(2 * node + 1, mid + 1, end, left, right);
    }
}
