import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        int[] dist = new int[100001];
        int[] prev = new int[100001];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(dist, -1);
        queue.add(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current - 1 >= 0 && dist[current - 1] == -1) {
                dist[current - 1] = dist[current] + 1;
                prev[current - 1] = current;
                queue.add(current - 1);
            }

            if (current + 1 <= 100000 && dist[current + 1] == -1) {
                dist[current + 1] = dist[current] + 1;
                prev[current + 1] = current;
                queue.add(current + 1);
            }

            if (current * 2 <= 100000 && dist[current * 2] == -1) {
                dist[current * 2] = dist[current] + 1;
                prev[current * 2] = current;
                queue.add(current * 2);
            }
        }

        System.out.println(dist[K]);

        List<Integer> path = new ArrayList<>();
        int current = K;
        while (current != N) {
            path.add(current);
            current = prev[current];
        }
        path.add(N);
        Collections.reverse(path);

        for (int p : path) {
            System.out.print(p + " ");
        }
    }
}
