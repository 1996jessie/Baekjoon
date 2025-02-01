import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int l, r, c, time;
        Point(int l, int r, int c, int time) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int L, R, C;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            visited = new boolean[L][R][C];

            Point start = null;
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = line.charAt(c);
                        if (building[l][r][c] == 'S') {
                            start = new Point(l, r, c, 0);
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(start);
            if (result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }
        }
        System.out.print(sb);
    }

    private static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.l][start.r][start.c] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (building[curr.l][curr.r][curr.c] == 'E') {
                return curr.time;
            }

            for (int i = 0; i < 6; i++) {
                int nl = curr.l + dl[i];
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (!visited[nl][nr][nc] && building[nl][nr][nc] != '#') {
                        visited[nl][nr][nc] = true;
                        queue.add(new Point(nl, nr, nc, curr.time + 1));
                    }
                }
            }
        }
        return -1;
    }
}
