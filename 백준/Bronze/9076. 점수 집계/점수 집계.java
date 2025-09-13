import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] scores = new int[5];
            for (int i = 0; i < 5; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores);
            int min = scores[0], max = scores[4];
            int[] middle = Arrays.copyOfRange(scores, 1, 4);
            int midMin = middle[0], midMax = middle[2];
            if (midMax - midMin >= 4) {
                sb.append("KIN\n");
            } else {
                int sum = middle[0] + middle[1] + middle[2];
                sb.append(sum).append("\n");
            }
        }
        System.out.print(sb);
    }
}
