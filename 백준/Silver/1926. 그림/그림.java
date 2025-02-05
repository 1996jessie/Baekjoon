import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        paper = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        int numberOfPictures = 0;
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j);
                    numberOfPictures++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        System.out.println(numberOfPictures);
        System.out.println(maxArea);
    }
    
    public static int dfs(int x, int y) {
        int area = 1;
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && paper[nx][ny] == 1 && !visited[nx][ny]) {
                area += dfs(nx, ny);
            }
        }
        
        return area;
    }
}
