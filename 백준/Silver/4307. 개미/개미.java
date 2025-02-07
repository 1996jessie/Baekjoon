import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int minTime = 0, maxTime = 0;

            for (int i = 0; i < n; i++) {
                int pos = Integer.parseInt(br.readLine());
                minTime = Math.max(minTime, Math.min(pos, L - pos));
                maxTime = Math.max(maxTime, Math.max(pos, L - pos));
            }

            sb.append(minTime).append(" ").append(maxTime).append("\n");
        }

        System.out.print(sb);
    }
}
