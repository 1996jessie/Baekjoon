import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(U);
        HashSet<Integer> sumSet = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumSet.add(U[i] + U[j]);
            }
        }
        
        for (int k = N - 1; k >= 0; k--) {
            for (int i = 0; i < k; i++) {
                if (sumSet.contains(U[k] - U[i])) {
                    System.out.println(U[k]);
                    return;
                }
            }
        }
    }
}
