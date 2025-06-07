import java.io.*;
import java.util.*;

public class Main {
    static final int DIM = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] cnt = new int[DIM][2];
        int[][] val = new int[DIM][2];

        for (int i = 0; i < 2047; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int d = 0; d < DIM; d++) {
                int x = Integer.parseInt(st.nextToken());
                if (cnt[d][0] == 0 || x == val[d][0]) {
                    val[d][0] = x;
                    cnt[d][0]++;
                } else {
                    val[d][1] = x;
                    cnt[d][1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d = 0; d < DIM; d++) {
            if (cnt[d][0] % 2 == 1) {
                sb.append(val[d][0]).append(" ");
            } else {
                sb.append(val[d][1]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
