import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] grid, blindGrid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        blindGrid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
                blindGrid[i][j] = (grid[i][j] == 'G') ? 'R' : grid[i][j];
            }
        }

        System.out.println(countRegions(grid) + " " + countRegions(blindGrid));
    }

    static int countRegions(char[][] board) {
        visited = new boolean[N][N];
        int regions = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(board, i, j, board[i][j]);
                    regions++;
                }
            }
        }
        return regions;
    }

    static void dfs(char[][] board, int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && board[nx][ny] == color) {
                    dfs(board, nx, ny, color);
                }
            }
        }
    }
}
