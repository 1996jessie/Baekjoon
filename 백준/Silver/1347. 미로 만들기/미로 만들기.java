import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String moves = sc.next();

        int dir = 2; // 남쪽
        int x = 0, y = 0;
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{x, y});

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'F') {
                x += dx[dir];
                y += dy[dir];
                path.add(new int[]{x, y});
            }
        }

        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        for (int[] p : path) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }

        int rows = maxX - minX + 1;
        int cols = maxY - minY + 1;

        char[][] maze = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(maze[i], '#');
        }

        for (int[] p : path) {
            int r = p[0] - minX;
            int c = p[1] - minY;
            maze[r][c] = '.';
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
