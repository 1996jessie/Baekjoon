import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> dp = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int index = binarySearch(dp, A[i]);
            if (index < dp.size()) {
                dp.set(index, A[i]);
            } else {
                dp.add(A[i]);
            }
        }
        
        System.out.println(dp.size());
    }
    
    private static int binarySearch(List<Integer> dp, int target) {
        int left = 0;
        int right = dp.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (dp.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
