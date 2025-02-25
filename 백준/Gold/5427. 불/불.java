import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] building;
    static int[][] fireTime, personTime;
    static Queue<int[]> fireQueue, personQueue;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            building = new char[h][w];
            fireTime = new int[h][w];
            personTime = new int[h][w];
            fireQueue = new LinkedList<>();
            personQueue = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                Arrays.fill(fireTime[i], -1);
                Arrays.fill(personTime[i], -1);
            }

            int startX = 0, startY = 0;
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    building[i][j] = line.charAt(j);
                    if (building[i][j] == '*') {
                        fireQueue.add(new int[]{i, j});
                        fireTime[i][j] = 0;
                    } else if (building[i][j] == '@') {
                        startX = i;
                        startY = j;
                    }
                }
            }

            spreadFire();
            int result = movePerson(startX, startY);
            sb.append(result == -1 ? "IMPOSSIBLE" : result).append("\n");
        }

        System.out.print(sb);
    }

    static void spreadFire() {
        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (isValid(nx, ny) && building[nx][ny] == '.' && fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = fireTime[x][y] + 1;
                    fireQueue.add(new int[]{nx, ny});
                }
            }
        }
    }

    static int movePerson(int startX, int startY) {
        personQueue.add(new int[]{startX, startY});
        personTime[startX][startY] = 0;

        while (!personQueue.isEmpty()) {
            int[] cur = personQueue.poll();
            int x = cur[0], y = cur[1];

            if (isEdge(x, y)) {
                return personTime[x][y] + 1;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (isValid(nx, ny) && building[nx][ny] == '.' && personTime[nx][ny] == -1 &&
                    (fireTime[nx][ny] == -1 || fireTime[nx][ny] > personTime[x][y] + 1)) {
                    personTime[nx][ny] = personTime[x][y] + 1;
                    personQueue.add(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == h - 1 || y == w - 1;
    }
}
