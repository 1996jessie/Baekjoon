import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], walls = cur[2];

            if (x == N - 1 && y == M - 1) {
                return walls;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int newWalls = walls + maze[nx][ny];
                    if (newWalls < dist[nx][ny]) {
                        dist[nx][ny] = newWalls;
                        pq.offer(new int[]{nx, ny, newWalls});
                    }
                }
            }
        }
        return -1;
    }
}
