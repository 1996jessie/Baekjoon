import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] lamps = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                lamps[i][j] = line.charAt(j) - '0';
            }
        }
        int K = sc.nextInt();

        Map<String, Integer> rowCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(lamps[i][j]);
            }
            String row = sb.toString();
            rowCount.put(row, rowCount.getOrDefault(row, 0) + 1);
        }

        int maxRows = 0;
        for (Map.Entry<String, Integer> entry : rowCount.entrySet()) {
            String row = entry.getKey();
            int count = entry.getValue();
            int zeroCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
            }
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                maxRows = Math.max(maxRows, count);
            }
        }

        System.out.println(maxRows);
    }
}
