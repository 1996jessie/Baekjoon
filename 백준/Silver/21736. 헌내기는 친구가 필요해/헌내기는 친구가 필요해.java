import java.io.*;
import java.util.*;

public class Main {
    static int N, M, startX, startY, peopleCount = 0;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') { 
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);
        System.out.println(peopleCount > 0 ? peopleCount : "TT");
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0], cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && campus[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    if (campus[nx][ny] == 'P') {
                        peopleCount++;
                    }
                }
            }
        }
    }
}
