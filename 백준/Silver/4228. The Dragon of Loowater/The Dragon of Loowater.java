import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            int[] heads = new int[n];
            int[] knights = new int[m];

            for (int i = 0; i < n; i++) {
                heads[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < m; i++) {
                knights[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(heads);
            Arrays.sort(knights);

            int totalCost = 0;
            int h = 0, k = 0;

            while (h < n && k < m) {
                if (knights[k] >= heads[h]) {
                    totalCost += knights[k];
                    h++;
                }
                k++;
            }

            if (h == n) {
                sb.append(totalCost).append("\n");
            } else {
                sb.append("Loowater is doomed!").append("\n");
            }
        }
        System.out.print(sb);
    }
}
