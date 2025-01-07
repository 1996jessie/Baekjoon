import java.util.*;

public class Main {
    static int M, N;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        box = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
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
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        box[nx][ny] = 1;
                        queue.add(new int[] {nx, ny});
                        flag = true;
                    }
                }
            }
            
            if (flag) {
                days++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
            }
        }

        return days;
    }
}
