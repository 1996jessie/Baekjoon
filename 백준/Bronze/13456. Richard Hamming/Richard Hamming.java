import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] v = new int[n];
            int[] u = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            int hammingDistance = 0;
            for (int i = 0; i < n; i++) {
                if (v[i] != u[i]) {
                    hammingDistance++;
                }
            }

            sb.append(hammingDistance).append("\n");
        }

        System.out.print(sb);
    }
}
