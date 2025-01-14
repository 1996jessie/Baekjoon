import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[][] price;
    static HashMap<Integer, int[][]> DP;
    static int DFS(int visit, int s, int p) {
        if (DP.get(visit) == null) {
            DP.put(visit, new int[N][10]);
        }

        if (DP.get(visit)[s][p] != 0) {
            return DP.get(visit)[s][p];
        }

        int cnt = 0;
        for (int i = 0; i < N; i ++) {
            if ((visit & 1 << i) == 0) {
                if (price[s][i] >= p) {
                   cnt = Math.max(cnt, DFS(visit | 1 << i, i, price[s][i]) + 1);
                }
            }
        }

        DP.get(visit)[s][p] = cnt;
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        price = new int[N][N];
        for (int i = 0; i < N; i++) {
            String t = br.readLine();
            for (int j = 0; j < N; j++) {
                price[i][j] = Integer.parseInt(String.valueOf(t.charAt(j)));
            }
        }

        DP = new HashMap<>();

        DP.put(1, new int[N][10]);
        System.out.println(DFS(1, 0, 0) + 1);

    }

}