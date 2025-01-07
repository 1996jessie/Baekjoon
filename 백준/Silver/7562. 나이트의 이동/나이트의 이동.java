import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        while (repeat-- > 0) {
            int N = sc.nextInt();
            int[] now_pos = {sc.nextInt(), sc.nextInt()};
            int[] target_pos = {sc.nextInt(), sc.nextInt()};

            int[][] arr = new int[N + 1][N + 1];
            Queue<int[]> q = new LinkedList<>();
            
            q.add(now_pos);
            arr[now_pos[0]][now_pos[1]] = 1;

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int x = current[0], y = current[1];
                if (x == target_pos[0] && y == target_pos[1]) {
                    System.out.println(arr[x][y] - 1);
                    break;
                }
                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (arr[nx][ny] == 0) {
                            arr[nx][ny] = arr[x][y] + 1;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
