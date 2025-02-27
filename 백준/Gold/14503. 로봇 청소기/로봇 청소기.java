import java.io.*;
import java.util.*;

public class Main {
    static int N, M, r, c, d, cleaned = 0;
    static int[][] room;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean();
        System.out.println(cleaned);
    }

    static void clean() {
        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = 2;
                cleaned++;
            }

            boolean dirty = false;
            for (int i = 0; i < 4; i++) {
                int nd = (d + 3) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if (room[nr][nc] == 0) {
                    d = nd;
                    r = nr;
                    c = nc;
                    dirty = true;
                    break;
                }
                d = nd;
            }

            if (!dirty) {
                int nr = r - dr[d];
                int nc = c - dc[d];

                if (room[nr][nc] == 1) {
                    return;
                }

                r = nr;
                c = nc;
            }
        }
    }
}
