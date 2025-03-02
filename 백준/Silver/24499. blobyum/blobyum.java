import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] pies = new int[N * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pies[i] = pies[i + N] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0, currentSum = 0;
        for (int i = 0; i < K; i++) {
            currentSum += pies[i];
        }
        maxSum = currentSum;

        for (int i = K; i < N + K; i++) {
            currentSum += pies[i] - pies[i - K];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
