import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int[] sang = new int[N];
            int[] sun = new int[M];

            for (int i = 0; i < N; i++) {
                sang[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                sun[i] = Integer.parseInt(br.readLine());
            }

            int i = 0, j = 0, cnt = 0;
            while (i < N && j < M) {
                if (sang[i] == sun[j]) {
                    cnt++;
                    i++;
                    j++;
                } else if (sang[i] < sun[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
