import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        box = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = sc.nextInt();
                    if (box[z][y][x] == 1) {
                        queue.add(new int[] {z, y, x});
                    }
                }
            }
        }

        int result = bfs();

        System.out.println(result);
        sc.close();
    }

    static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int z = current[0], y = current[1], x = current[2];

                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = box[z][y][x] + 1;
                        queue.add(new int[] {nz, ny, nx});
                    }
                }
            }

            days++;
        }

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 0) {
                        return -1;
                    }
                }
            }
        }

        return days - 1;
    }
}
