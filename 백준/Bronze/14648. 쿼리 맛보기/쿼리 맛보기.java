import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static int n;
    
    static long rangeSum(int l, int r) {
        long sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long sum = rangeSum(a, b);
                sb.append(sum).append("\n");
                long tmp = arr[a];
                arr[a] = arr[b];
                arr[b] = tmp;
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                long sum1 = rangeSum(a, b);
                long sum2 = rangeSum(c, d);
                sb.append(sum1 - sum2).append("\n");
            }
        }
        System.out.print(sb);
    }
}
