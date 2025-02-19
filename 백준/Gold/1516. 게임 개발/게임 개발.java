import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N + 1];
        int[] inDegree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;
                graph.get(pre).add(i);
                inDegree[i]++;
            }
        }

        int[] result = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                result[next] = Math.max(result[next], result[now] + time[next]);
                if (--inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}
