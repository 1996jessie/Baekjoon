import java.io.*;
import java.util.*;

public class Main {
    static int N, time, size = 2, eat = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static Shark shark;

    static class Shark {
        int x, y;
        Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish fish = bfs();
            if (fish == null) break;
            time += fish.dist;
            shark.x = fish.x;
            shark.y = fish.y;
            map[fish.x][fish.y] = 0;
            eat++;
            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(time);
    }

    static Fish bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][N];
        q.offer(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;
        List<Fish> fishes = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], d = now[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] > size) continue;

                visited[nx][ny] = true;
                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    fishes.add(new Fish(nx, ny, d + 1));
                }
                q.offer(new int[]{nx, ny, d + 1});
            }
        }

        if (fishes.isEmpty()) return null;
        Collections.sort(fishes);
        return fishes.get(0);
    }
}
