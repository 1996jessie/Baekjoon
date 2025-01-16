import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Long, Integer> sumA = new HashMap<>();
        Map<Long, Integer> sumB = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.put(sum, sumA.getOrDefault(sum, 0) + 1);
            }
        }
        
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.put(sum, sumB.getOrDefault(sum, 0) + 1);
            }
        }
        
        long result = 0;
        for (Map.Entry<Long, Integer> entry : sumA.entrySet()) {
            long complement = T - entry.getKey();
            if (sumB.containsKey(complement)) {
                result += (long) entry.getValue() * sumB.get(complement);
            }
        }
        
        System.out.println(result);
    }
}
