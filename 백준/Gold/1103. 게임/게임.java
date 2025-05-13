import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    static boolean infinite = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, 1);
        System.out.println(infinite ? -1 : max);
    }

    static void dfs(int x, int y, int count) {
        if (infinite) {
            return;
        }
        max = Math.max(max, count);
        dp[x][y] = count;
        visited[x][y] = true;
        int move = board[x][y] - '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * move;
            int ny = y + dy[i] * move;
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 'H') {
                continue;
            }
            if (visited[nx][ny]) {
                infinite = true;
                return;
            }
            if (dp[nx][ny] > count) {
                continue;
            }
            dfs(nx, ny, count + 1);
        }
        visited[x][y] = false;
    }
}
