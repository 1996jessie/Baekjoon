import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] lastYear = new int[n + 1];
            int[] inDegree = new int[n + 1];
            boolean[][] adjMatrix = new boolean[n + 1][n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                lastYear[i + 1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    adjMatrix[lastYear[i]][lastYear[j]] = true;
                    inDegree[lastYear[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (adjMatrix[a][b]) {
                    adjMatrix[a][b] = false;
                    adjMatrix[b][a] = true;
                    inDegree[b]--;
                    inDegree[a]++;
                } else {
                    adjMatrix[b][a] = false;
                    adjMatrix[a][b] = true;
                    inDegree[a]--;
                    inDegree[b]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            boolean isAmbiguous = false;
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                if (queue.isEmpty()) {
                    isImpossible = true;
                    break;
                }

                if (queue.size() > 1) {
                    isAmbiguous = true;
                }

                int current = queue.poll();
                result.add(current);

                for (int j = 1; j <= n; j++) {
                    if (adjMatrix[current][j]) {
                        inDegree[j]--;
                        if (inDegree[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
            }

            if (isImpossible) {
                sb.append("IMPOSSIBLE").append("\n");
            } else if (isAmbiguous) {
                sb.append("?").append("\n");
            } else {
                for (int team : result) {
                    sb.append(team).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
