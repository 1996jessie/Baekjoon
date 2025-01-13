import java.io.*;
import java.util.*;

public class Main {
    static int[] buildTime;
    static int[] inDegree;
    static int[] totalTime;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            buildTime = new int[N + 1];
            totalTime = new int[N + 1];
            inDegree = new int[N + 1];
            adjList = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adjList[X].add(Y);
                inDegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                totalTime[i] = buildTime[i];
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : adjList[current]) {
                    totalTime[next] = Math.max(totalTime[next], totalTime[current] + buildTime[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            bw.write(totalTime[W] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
