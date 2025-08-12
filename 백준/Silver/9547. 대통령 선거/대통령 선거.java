import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int[][] prefs = new int[V][C];
            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    prefs[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] count = new int[C + 1];
            for (int i = 0; i < V; i++) {
                count[prefs[i][0]]++;
            }
            int majority = V / 2 + 1;
            int first = 0, second = 0;
            for (int i = 1; i <= C; i++) {
                if (count[i] > count[first]) {
                    second = first;
                    first = i;
                } else if (count[i] > count[second]) {
                    second = i;
                }
            }
            if (count[first] >= majority) {
                sb.append(first).append(" 1\n");
                continue;
            }
            int fVotes = 0, sVotes = 0;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < C; j++) {
                    if (prefs[i][j] == first) {
                        fVotes++;
                        break;
                    } else if (prefs[i][j] == second) {
                        sVotes++;
                        break;
                    }
                }
            }
            if (fVotes > sVotes) sb.append(first).append(" 2\n");
            else sb.append(second).append(" 2\n");
        }
        System.out.print(sb.toString());
    }
}
