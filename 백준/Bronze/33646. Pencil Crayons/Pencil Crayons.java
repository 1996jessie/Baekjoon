import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> colorIndex = new HashMap<>();
        int idx = 0;
        int[][] count = new int[N][K];
        int[] colorTotal = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                String color = st.nextToken();
                if (!colorIndex.containsKey(color)) {
                    colorIndex.put(color, idx++);
                }
                int id = colorIndex.get(color);
                count[i][id]++;
                colorTotal[id]++;
            }
        }

        int totalRemovals = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> uniqueColors = new HashSet<>();
            for (int j = 0; j < K; j++) {
                if (count[i][j] > 0) {
                    uniqueColors.add(j);
                    if (count[i][j] > 1) {
                        totalRemovals += count[i][j] - 1;
                    }
                }
            }
            if (uniqueColors.size() > K) {
                totalRemovals += uniqueColors.size() - K;
            }
        }

        System.out.println(totalRemovals);
    }
}
