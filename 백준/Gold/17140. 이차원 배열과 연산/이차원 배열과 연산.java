import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] A = new int[101][101];
    static int row = 3, col = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time <= 100) {
            if (A[r][c] == k) {
                System.out.println(time);
                return;
            }
            if (row >= col) {
                R();
            } else {
                C();
            }
            time++;
        }
        System.out.println(-1);
    }

    static void R() {
        int maxCol = 0;
        for (int i = 1; i <= row; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j <= col; j++) {
                if (A[i][j] == 0) continue;
                map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }
            list.sort((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });
            int idx = 1;
            for (int[] pair : list) {
                if (idx > 100) break;
                A[i][idx++] = pair[0];
                if (idx > 100) break;
                A[i][idx++] = pair[1];
            }
            for (int j = idx; j <= 100; j++) {
                A[i][j] = 0;
            }
            maxCol = Math.max(maxCol, idx - 1);
        }
        col = maxCol;
    }

    static void C() {
        int maxRow = 0;
        for (int j = 1; j <= col; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= row; i++) {
                if (A[i][j] == 0) continue;
                map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }
            list.sort((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });
            int idx = 1;
            for (int[] pair : list) {
                if (idx > 100) break;
                A[idx++][j] = pair[0];
                if (idx > 100) break;
                A[idx++][j] = pair[1];
            }
            for (int i = idx; i <= 100; i++) {
                A[i][j] = 0;
            }
            maxRow = Math.max(maxRow, idx - 1);
        }
        row = maxRow;
    }
}
