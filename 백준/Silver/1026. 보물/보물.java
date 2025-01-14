import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        
        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
            B[i] = Integer.parseInt(inputB[i]);
        }
        
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }
        
        System.out.println(S);
    }
}
