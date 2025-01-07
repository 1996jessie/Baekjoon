import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        dist = new int[N][M][2];
        
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }
        
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], broken = current[2];

            if (x == N - 1 && y == M - 1) {
                return dist[x][y][broken];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && dist[nx][ny][broken] == -1) {
                        dist[nx][ny][broken] = dist[x][y][broken] + 1;
                        queue.offer(new int[]{nx, ny, broken});
                    }

                    if (map[nx][ny] == 1 && broken == 0 && dist[nx][ny][1] == -1) {
                        dist[nx][ny][1] = dist[x][y][broken] + 1;
                        queue.offer(new int[]{nx, ny, 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
