import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int size = N * N;
            int[][] grid = new int[size][size];
            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean valid = true;
            for (int i = 0; i < size && valid; i++) {
                boolean[] seen = new boolean[size + 1];
                for (int j = 0; j < size; j++) {
                    int v = grid[i][j];
                    if (v < 1 || v > size || seen[v]) {
                        valid = false;
                        break;
                    }
                    seen[v] = true;
                }
            }
            for (int j = 0; j < size && valid; j++) {
                boolean[] seen = new boolean[size + 1];
                for (int i = 0; i < size; i++) {
                    int v = grid[i][j];
                    if (v < 1 || v > size || seen[v]) {
                        valid = false;
                        break;
                    }
                    seen[v] = true;
                }
            }
            for (int bi = 0; bi < size && valid; bi += N) {
                for (int bj = 0; bj < size && valid; bj += N) {
                    boolean[] seen = new boolean[size + 1];
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            int v = grid[bi + i][bj + j];
                            if (v < 1 || v > size || seen[v]) {
                                valid = false;
                                break;
                            }
                            seen[v] = true;
                        }
                    }
                }
            }
            sb.append("Case #").append(tc).append(": ").append(valid ? "Yes" : "No").append("\n");
        }
        System.out.print(sb.toString());
    }
}
