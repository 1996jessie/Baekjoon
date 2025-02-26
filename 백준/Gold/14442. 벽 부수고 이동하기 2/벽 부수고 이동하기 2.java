import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, dist, broken;

        Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(n, m, k, map));
    }

    private static int bfs(int n, int m, int k, int[][] map) {
        int[][][] visited = new int[n][m][k + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && visited[nx][ny][cur.broken] == 0) {
                        visited[nx][ny][cur.broken] = 1;
                        queue.add(new Node(nx, ny, cur.dist + 1, cur.broken));
                    } else if (map[nx][ny] == 1 && cur.broken < k && visited[nx][ny][cur.broken + 1] == 0) {
                        visited[nx][ny][cur.broken + 1] = 1;
                        queue.add(new Node(nx, ny, cur.dist + 1, cur.broken + 1));
                    }
                }
            }
        }
        return -1;
    }
}
