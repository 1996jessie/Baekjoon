import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] lamps = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                lamps[i][j] = line.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());

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

        bw.write(maxRows + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
