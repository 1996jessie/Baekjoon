import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] segTreeMin, segTreeMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        segTreeMin = new int[4 * N];
        segTreeMax = new int[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = queryMin(1, N, 1, a, b);
            int max = queryMax(1, N, 1, a, b);

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void init(int start, int end, int node) {
        if (start == end) {
            segTreeMin[node] = arr[start];
            segTreeMax[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);

        segTreeMin[node] = Math.min(segTreeMin[node * 2], segTreeMin[node * 2 + 1]);
        segTreeMax[node] = Math.max(segTreeMax[node * 2], segTreeMax[node * 2 + 1]);
    }

    public static int queryMin(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return segTreeMin[node];
        }

        int mid = (start + end) / 2;
        int leftMin = queryMin(start, mid, node * 2, left, right);
        int rightMin = queryMin(mid + 1, end, node * 2 + 1, left, right);

        return Math.min(leftMin, rightMin);
    }

    public static int queryMax(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return Integer.MIN_VALUE;
        }

        if (left <= start && end <= right) {
            return segTreeMax[node];
        }

        int mid = (start + end) / 2;
        int leftMax = queryMax(start, mid, node * 2, left, right);
        int rightMax = queryMax(mid + 1, end, node * 2 + 1, left, right);

        return Math.max(leftMax, rightMax);
    }
}
