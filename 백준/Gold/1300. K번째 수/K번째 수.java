import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        long start = 1;
        long end = (long) n * n;
        
        while (start < end) {
            long mid = (start + end) / 2;
            long small_cnt = 0;
            
            for (int i = 1; i <= n; i++) {
                small_cnt += Math.min(mid / i, n);
            }
            
            if (small_cnt < k) {
                start = mid + 1;
            } else { 
                end = mid;
            }
        }
        
        System.out.println(start);
    }
}
