import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] board = new int[101];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x] = y;
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            board[u] = v;
        }

        System.out.println(bfs(board));
    }

    static int bfs(int[] board) {
        boolean[] visited = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int[] moves = {1, 2, 3, 4, 5, 6};

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == 100) {
                    return steps;
                }

                for (int move : moves) {
                    int next = current + move;
                    if (next <= 100 && !visited[next]) {
                        visited[next] = true;
                        if (board[next] != 0) {
                            next = board[next];
                        }
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
