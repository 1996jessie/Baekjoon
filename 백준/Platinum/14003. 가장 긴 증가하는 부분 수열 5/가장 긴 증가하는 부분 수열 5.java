import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long[] A = new long[N];
        int[] dp = new int[N];
        int[] prev = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        
        ArrayList<Long> lis = new ArrayList<>();
        Arrays.fill(prev, -1);
        
        for (int i = 0; i < N; i++) {
            int pos = lowerBound(lis, A[i]);
            if (pos < lis.size()) {
                lis.set(pos, A[i]);
            } else {
                lis.add(A[i]);
            }
            dp[i] = pos;
            if (pos > 0) {
                prev[i] = dp[pos - 1];
            }
        }
        
        System.out.println(lis.size());
        
        Stack<Long> stack = new Stack<>();
        int idx = N - 1;
        while (idx >= 0) {
            if (dp[idx] == lis.size() - 1) {
                stack.push(A[idx]);
                lis.remove(lis.size() - 1);
            }
            idx--;
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static int lowerBound(ArrayList<Long> list, long x) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
