import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> directions;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = 1;
        }
        
        int L = Integer.parseInt(br.readLine());
        directions = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directions.put(time, dir);
        }
        
        System.out.println(playGame());
    }

    static int playGame() {
        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{0, 0});
        int time = 0, dir = 0, x = 0, y = 0;

        while (true) {
            time++;
            x += dx[dir];
            y += dy[dir];
            
            if (x < 0 || x >= N || y < 0 || y >= N) {
                break;
            }
            for (int[] s : snake) {
                if (s[0] == x && s[1] == y) {
                    return time;
                }
            }
            snake.offerFirst(new int[]{x, y});
            if (board[x][y] == 1) {
                board[x][y] = 0;
            } else {
                snake.pollLast();
            }
            if (directions.containsKey(time)) {
                if (directions.get(time) == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }
        return time;
    }
}
