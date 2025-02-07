import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int testCase = 1;
        
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int[][] cave = new int[N][N];
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, cave[0][0]));
            dist[0][0] = cave[0][0];
            
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.cost > dist[cur.x][cur.y]) {
                    continue;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        int newCost = cur.cost + cave[nx][ny];
                        if (newCost < dist[nx][ny]) {
                            dist[nx][ny] = newCost;
                            pq.add(new Node(nx, ny, newCost));
                        }
                    }
                }
            }
            
            sb.append("Problem ").append(testCase++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        
        System.out.print(sb);
    }
}
